package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.port.IShippingInfoPort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetOrderUseCase {

    private final IOrderPort orderPort;

    private final GetOrderLineUseCase getOrderLineUseCase;

    private final IShippingInfoPort shippingInfoPort;

    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request) {

        var result = orderPort.getAllOrder(request);

        if (ObjectUtils.isEmpty(result) || CollectionUtils.isEmpty(result.getSecond()))
            return result;

        var orders = result.getSecond();
        var orderIds = orders.stream().map(OrderEntity::getId).toList();
        var orderLines = getOrderLineUseCase.getOrderLineByOrderIds(orderIds);
        if (CollectionUtils.isEmpty(orderLines))
            return result;

        var shippingInfoIds = orders.stream().map(OrderEntity::getShippingInfoId).toList();
        var shippingInfos = shippingInfoPort.getInfoByIds(shippingInfoIds);
        if (CollectionUtils.isEmpty(shippingInfos))
            return result;
        var mapShippingInfo = shippingInfos.stream()
                .collect(Collectors.toMap(ShippingInfoEntity::getId, Function.identity()));
        orders = orders.stream().peek(order -> {
            var lines = orderLines.stream()
                    .filter(orderLine -> orderLine.getOrderId().equals(order.getId()))
                    .toList();
            order.setOrderLines(lines);


            var shippingInfo = mapShippingInfo.getOrDefault(order.getShippingInfoId(), null);
            order.setShippingInfo(shippingInfo);
        }).toList();



        return Pair.of(result.getFirst(), orders);
    }

    public OrderEntity getOrderById(Long orderId) {
        var order = orderPort.getOrderById(orderId);
        var orderLines = getOrderLineUseCase.getOrderLineByOrderId(orderId);
        order.setOrderLines(orderLines);
        return order;
    }
}
