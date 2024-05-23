package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.service.IProductDetailService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateProductDetailUseCase;

@Service
@RequiredArgsConstructor
public class ProductDetailService implements IProductDetailService {

    private final CreateProductDetailUseCase createProductDetailUseCase;

    @Override
    public ProductDetailEntity createProductDetail(CreateProductDetailRequest request) {
        return createProductDetailUseCase.createProductDetail(request);
    }
}
