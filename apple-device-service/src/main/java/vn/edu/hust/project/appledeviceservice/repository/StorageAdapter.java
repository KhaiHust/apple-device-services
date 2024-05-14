package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IStorageRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.StorageModelMapper;

@Service
@RequiredArgsConstructor
public class StorageAdapter implements IStoragePort {

    private final IStorageRepository storageRepository;

    @Override
    public StorageEntity save(StorageEntity storageEntity) {
        return StorageModelMapper.INSTANCE.toStorageEntity(
                storageRepository.save(StorageModelMapper.INSTANCE.toStorageModel(storageEntity))
        );
    }
}
