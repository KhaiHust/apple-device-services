package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IOrderService {
    Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request);
}
