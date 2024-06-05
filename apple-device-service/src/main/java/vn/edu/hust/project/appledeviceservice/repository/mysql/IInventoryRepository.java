package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.InventoryModel;

import java.util.List;

@Repository
public interface IInventoryRepository extends IBaseRepository<InventoryModel> {
    List<InventoryModel> findByProductDetailIdIn(List<Long> productDetailIds);
}
