package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.CartModel;

import java.util.List;

@Repository
public interface ICartRepository extends IBaseRepository<CartModel> {
    List<CartModel> findByUserId(Long userId);
}
