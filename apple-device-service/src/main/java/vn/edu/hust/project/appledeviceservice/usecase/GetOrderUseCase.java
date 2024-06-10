package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderUseCase {
    private final IOrderPort orderPort;

    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request) {
        return orderPort.getAllOrder(request);
    }

}
