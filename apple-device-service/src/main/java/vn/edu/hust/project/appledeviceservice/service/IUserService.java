package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.LoginResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.SignUpResponse;

public interface IUserService {
    SignUpResponse sigUpOps(CreateUserRequest request);

    LoginResponse loginOps(LoginRequest request);

    LoginResponse loginWeb(LoginRequest request);

    SignUpResponse signUpWeb(CreateUserWebRequest request);
}
