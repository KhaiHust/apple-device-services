package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.service.ICartService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateCartUseCase;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CreateCartUseCase createCartUseCase;

    @Override
    public CartEntity createCart(CreateCartRequest request, Long userId) {
        return createCartUseCase.createCart(request, userId);
    }
}
