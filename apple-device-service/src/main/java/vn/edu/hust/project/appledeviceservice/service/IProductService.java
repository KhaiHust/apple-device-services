package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;

public interface IProductService {
    ProductEntity createProduct(CreateProductRequest request);
}
