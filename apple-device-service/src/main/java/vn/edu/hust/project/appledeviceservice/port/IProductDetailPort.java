package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;

public interface IProductDetailPort {
    ProductDetailEntity save(ProductDetailEntity entity);
}
