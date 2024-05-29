package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.mapper.UserResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final IUserPort userPort;

    private final PasswordEncoder passwordEncoder;
    public UserEntity createUser(CreateUserRequest request) {

        var user = UserResourceMapper.INSTANCE.fromRequestToEntity(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userPort.save(user);
        user.setPassword(null);

        return user;
    }
}
