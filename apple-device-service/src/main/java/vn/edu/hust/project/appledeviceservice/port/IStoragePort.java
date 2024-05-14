package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;

public interface IStoragePort {
    StorageEntity save(StorageEntity storageEntity);
}
