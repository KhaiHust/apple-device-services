


package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateUserException;
import vn.edu.hust.project.appledeviceservice.exception.GetUserException;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IUserRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.UserModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAdapter implements IUserPort {

    private final IUserRepository userRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        try {
            return UserModelMapper.INSTANCE.toEntity(
                    userRepository.save(UserModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception e) {
            log.error("[UserAdapter] Create user fail, err: " + e.getMessage());
            throw new CreateUserException();
        }
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return UserModelMapper.INSTANCE.toEntity(
                userRepository.findByEmail(email).orElseThrow(GetUserException::new)
        );
    }
}