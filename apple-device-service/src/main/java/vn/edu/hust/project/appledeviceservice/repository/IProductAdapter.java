package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateProductException;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProductRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ProductModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class IProductAdapter implements IProductPort {

    private final IProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        try {
            return ProductModelMapper.INSTANCE.toEntity(
                    productRepository.save(ProductModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception ex){
            log.error("[IProductAdapter] Failed to save product, error: " + ex.getMessage());
            throw new CreateProductException();
        }

    }
}
