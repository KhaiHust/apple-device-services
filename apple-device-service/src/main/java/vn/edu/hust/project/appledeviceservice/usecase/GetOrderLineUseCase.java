package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderLineUseCase {
    private final IOrderLinePort orderLinePort;

    public List<OrderLineEntity> getOrderLineByOrderIds(List<Long> orderIds) {
        return orderLinePort.getOrderLineByOrderIds(orderIds);
    }
}
