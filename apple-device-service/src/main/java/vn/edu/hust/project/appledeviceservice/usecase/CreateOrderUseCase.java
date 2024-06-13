package vn.edu.hust.project.appledeviceservice.usecase;


import io.lettuce.core.RedisConnectionException;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.Key;
import vn.edu.hust.project.appledeviceservice.constant.OrderState;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateOrderRequest;
import vn.edu.hust.project.appledeviceservice.mapper.OrderResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.port.IRedisPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {

    private final IOrderPort orderPort;
    private final IInventoryPort inventoryPort;
    private final IRedisPort redisPort;
    private final IOrderLinePort orderLinePort;

    @Transactional(rollbackFor = Exception.class)
    public OrderEntity createOrder(CreateOrderRequest createOrderRequest) {
        try {
            var orderLines = createOrderRequest.getOrderLines();
            if (CollectionUtils.isEmpty(orderLines)) {
                //Todo create exception
                throw new IllegalArgumentException("Order lines is empty");
            }

            var order = OrderResourceMapper.INSTANCE.createOrderFromRequest(createOrderRequest);
            order.setState(OrderState.PENDING.name());
            order = orderPort.save(order);

            var orderLineEntities = new ArrayList<OrderLineEntity>();
            for (var orderLine : orderLines) {
                var lockKey =
                    Key.INVENTORY_PRODUCT_DETAIL.getPrefixKey() + orderLine.getProductDetailId();
                var newOrderLine = new OrderLineEntity();
                newOrderLine.setOrderId(order.getId());
                newOrderLine.setProductDetailId(orderLine.getProductDetailId());
                newOrderLine.setQuantity(orderLine.getQuantity());

                while (true) {
                    try {
                        if (Boolean.TRUE.equals(
                            redisPort.lockKey(lockKey, order.getId().toString(), 10L))) {
                            changeInventory(orderLine.getProductDetailId(),
                                orderLine.getQuantity());
                            orderLineEntities.add(orderLinePort.save(newOrderLine));
                            break;
                        }
                    } catch (RedisConnectionException e) {
                        log.error("Error when creating order line", e);
                        // Add additional error handling here if necessary
                    } finally {
                        redisPort.deleteKey(lockKey);
                    }

                    // If the lock could not be acquired, wait for a short time before trying again
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread was interrupted", e);
                    }
                }
            }
            order.setOrderLines(orderLineEntities);
            return order;
        } catch (Exception ex) {
            log.error("Error when create order", ex);
            //Todo create exception
            throw new IllegalArgumentException("Can not create order");

        }

    }

    private void changeInventory(Long productDetailId, Long quantity) {
        var inventory = inventoryPort.getInventoryByProductDetailId(productDetailId);
        if (inventory == null || quantity > inventory.getAvailable()) {
            //Todo create exception
            throw new IllegalArgumentException("Inventory not found");
        }

        inventory.setAvailable(inventory.getAvailable() - quantity);
        inventory.setSold(inventory.getSold() + quantity);
        inventoryPort.save(inventory);
    }
}
