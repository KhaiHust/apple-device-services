package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;
@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {
}
