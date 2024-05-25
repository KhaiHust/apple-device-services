package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.service.IInventoryService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateInventoryUseCase;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService {

    private final CreateInventoryUseCase createInventoryUseCase;

    @Override
    public InventoryEntity createInventory(CreateInventoryRequest request) {
        return createInventoryUseCase.createInventory(request);
    }
}
