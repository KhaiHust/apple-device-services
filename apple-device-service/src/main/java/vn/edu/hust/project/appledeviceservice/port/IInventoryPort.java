package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;

public interface IInventoryPort {
    InventoryEntity save(InventoryEntity entity);
}
