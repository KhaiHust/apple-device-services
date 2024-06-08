package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;

import java.util.List;

public interface ICartPort {
    CartEntity save(CartEntity cartEntity);

    List<CartEntity> getCartByUserId(Long userId);
}
