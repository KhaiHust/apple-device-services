package vn.edu.hust.project.appledeviceservice.usecase;


import io.lettuce.core.RedisConnectionException;
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
import vn.edu.hust.project.appledeviceservice.exception.ChangeInventoryException;
import vn.edu.hust.project.appledeviceservice.exception.CreateOrderException;
import vn.edu.hust.project.appledeviceservice.exception.NotEnoughInventoryException;
import vn.edu.hust.project.appledeviceservice.exception.RedisConnectException;
import vn.edu.hust.project.appledeviceservice.mapper.OrderResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IRedisPort;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {

    private final IOrderPort orderPort;
    private final IInventoryPort inventoryPort;
    private final IRedisPort redisPort;
    private final IOrderLinePort orderLinePort;
    private final IProductDetailPort productDetailPort;

    @Transactional(rollbackFor = Exception.class)
    public OrderEntity createOrder(CreateOrderRequest createOrderRequest) {
        try {
            var orderLines = createOrderRequest.getOrderLines();
            var productDetailIds = orderLines.stream()
                    .map(orderLine -> orderLine.getProductDetailId())
                    .collect(Collectors.toList());
            var productDetails = productDetailPort.getProductDetailByIds(productDetailIds);

            var totalPrice = productDetails.stream()
                    .mapToLong(productDetail -> productDetail.getPrice())
                    .sum();
            if (CollectionUtils.isEmpty(orderLines)) {
                log.error("[CreateOrderUseCase] Order lines is empty");
                throw new CreateOrderException();
            }

            var order = OrderResourceMapper.INSTANCE.createOrderFromRequest(createOrderRequest);
            order.setState(OrderState.PENDING.name());
            order.setTotalPrice(totalPrice);
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
                        log.error("[CreateOrderUseCase] Redis connect fail, err: " + e.getMessage());
                        throw new RedisConnectException();
                    } finally {
                        log.info("[CreateOrderUseCase] Release lock key: " + lockKey);
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
        } catch (ChangeInventoryException ex) {
            throw new NotEnoughInventoryException();
        } catch (Exception ex) {
            throw new CreateOrderException();
        }

    }

    private void changeInventory(Long productDetailId, Long quantity) {
        var inventory = inventoryPort.getInventoryByProductDetailId(productDetailId);
        if (inventory == null || quantity > inventory.getAvailable()) {
            log.error("[CreateOrderUseCase] Inventory is not enough");
            throw new ChangeInventoryException();
        }

        inventory.setAvailable(inventory.getAvailable() - quantity);
        inventory.setSold(inventory.getSold() + quantity);

        inventoryPort.save(inventory);
    }
}
