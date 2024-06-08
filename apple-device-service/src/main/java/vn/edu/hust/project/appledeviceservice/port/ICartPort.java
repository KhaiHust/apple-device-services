package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;

public interface ICartPort {
    CartEntity save(CartEntity cartEntity);
}
