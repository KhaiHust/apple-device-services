package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;

public interface IProductPort {
    ProductEntity save(ProductEntity entity);
}
