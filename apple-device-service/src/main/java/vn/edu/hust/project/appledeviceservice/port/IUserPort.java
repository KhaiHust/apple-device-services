package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;

public interface IUserPort {
    UserEntity save(UserEntity entity);

    UserEntity getUserByEmail(String email);
}
