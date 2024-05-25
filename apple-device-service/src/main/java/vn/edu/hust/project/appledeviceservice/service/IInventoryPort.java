package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;

public interface IInventoryPort {
    InventoryEntity save(InventoryEntity entity);
}
