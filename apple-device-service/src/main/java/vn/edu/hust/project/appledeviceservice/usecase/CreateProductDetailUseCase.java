package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;

@Service
@RequiredArgsConstructor
public class CreateProductDetailUseCase {
    private final IProductDetailPort productDetailPort;

    private final IImagePort imagePort;

    public ProductDetailEntity createProductDetail(CreateProductDetailRequest request){


        return null;
    }
}
