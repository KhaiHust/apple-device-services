package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IOrderService;
import vn.edu.hust.project.appledeviceservice.usecase.GetOrderUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final GetOrderUseCase getOrderUseCase;

    @Override
    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request) {
        return getOrderUseCase.getAllOrder(request);
    }
}
