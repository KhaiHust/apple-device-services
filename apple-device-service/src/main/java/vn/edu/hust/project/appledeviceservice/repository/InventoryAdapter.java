package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateInventoryException;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IInventoryRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.InventoryModelMapper;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryAdapter implements IInventoryPort {

    private final IInventoryRepository inventoryRepository;

    @Override
    public InventoryEntity save(InventoryEntity entity) {
        try {
            return InventoryModelMapper.INSTANCE.toEntity(
                    inventoryRepository.save(
                            InventoryModelMapper.INSTANCE.toModel(entity)
                    )
            );
        } catch (Exception e) {
            log.error("[InventoryAdapter] Create inventory fail, err: " + e.getMessage());
            throw new CreateInventoryException();
        }
    }
}
