package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateCartException;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.ICartRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.CartModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartAdapter implements ICartPort {
    private final ICartRepository cartRepository;

    @Override
    public CartEntity save(CartEntity cartEntity) {
        try {
            return CartModelMapper.INSTANCE.toEntity(cartRepository.save(
                    CartModelMapper.INSTANCE.toModel(cartEntity)
            ));
        } catch (Exception e) {
            log.error("[CartAdapter] save cart error: {}", e.getMessage());
            throw new CreateCartException();
        }
    }
}
