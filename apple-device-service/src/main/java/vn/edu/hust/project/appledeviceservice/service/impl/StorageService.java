package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.service.IStorageService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateStorageUseCase;

@Service
@RequiredArgsConstructor
public class StorageService implements IStorageService {

    private final CreateStorageUseCase createStorageUseCase;

    @Override
    public StorageEntity createStorage(StorageEntity storageEntity) {
        return createStorageUseCase.createStorage(storageEntity);
    }
}
