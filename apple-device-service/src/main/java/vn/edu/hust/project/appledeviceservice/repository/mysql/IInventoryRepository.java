package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.InventoryModel;

@Repository
public interface IInventoryRepository extends IBaseRepository<InventoryModel> {
}
