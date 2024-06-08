package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.mapper.CartResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;

@Service
@RequiredArgsConstructor
public class CreateCartUseCase {
    private final ICartPort cartPort;

    public CartEntity createCart(CreateCartRequest request, Long userId){
        //Todo: validate cart by user before add
        var cartEntity = CartResourceMapper.INSTANCE.toEntityFromRequest(request);
        cartEntity.setUserId(userId);
        return cartPort.save(cartEntity);
    }
}
