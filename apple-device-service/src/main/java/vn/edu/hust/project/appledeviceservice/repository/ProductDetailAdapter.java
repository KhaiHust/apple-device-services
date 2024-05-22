package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateProductDetailException;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProductDetailRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ProductDetailModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDetailAdapter implements IProductDetailPort {
    private final IProductDetailRepository productDetailRepository;
    @Override
    public ProductDetailEntity save(ProductDetailEntity entity) {
        try {
            return ProductDetailModelMapper.INSTANCE.toEntity(
                    productDetailRepository.save(ProductDetailModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception ex) {
            log.error("[ProductDetailAdapter] create product detail fail, err: " + ex.getMessage());
            throw new CreateProductDetailException();
        }
    }
}
