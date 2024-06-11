package vn.edu.hust.project.appledeviceservice.repository.mysql;

import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderLineModel;

import java.util.List;

public interface IOrderLineRepository extends IBaseRepository<OrderLineModel> {
    List<OrderLineModel> findByOrderIdIn(List<Long> orderIds);
}
