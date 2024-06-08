package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;

public interface ICartService {
    CartEntity createCart(CreateCartRequest request, Long userId);
}
