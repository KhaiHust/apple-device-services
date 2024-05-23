package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
@Service
public interface IProductDetailService {
    ProductDetailEntity createProductDetail(CreateProductDetailRequest request);
}
