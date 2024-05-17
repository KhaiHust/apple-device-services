package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.service.IProductService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateProductUseCase;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final CreateProductUseCase createProductUseCase;

    @Override
    public ProductEntity createProduct(CreateProductRequest request) {
        return createProductUseCase.createProduct(request);
    }
}
