package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;

public interface IInventoryService {
    InventoryEntity createInventory(CreateInventoryRequest request);
}
