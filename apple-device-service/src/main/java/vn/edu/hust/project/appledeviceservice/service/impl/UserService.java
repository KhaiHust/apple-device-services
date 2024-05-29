package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.dto.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.LoginResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.SignUpResponse;
import vn.edu.hust.project.appledeviceservice.service.IUserService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateUserUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.SignInUserUseCase;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final CreateUserUseCase createUserUseCase;

    private final SignInUserUseCase signInUserUseCase;

    @Override
    public SignUpResponse sigUpOps(CreateUserRequest request) {
        return createUserUseCase.createUser(request);
    }

    @Override
    public LoginResponse loginOps(LoginRequest request) {
        return signInUserUseCase.login(request);
    }
}
