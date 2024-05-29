package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.LoginRequest;
import vn.edu.hust.project.appledeviceservice.exception.LoginException;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.security.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class SignInUserUseCase {

    private final IUserPort userPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public String login(LoginRequest request) {
        var existedUser = userPort.getUserByEmail(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), existedUser.getPassword())) {
            throw new LoginException();
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            existedUser.getEmail(), request.getPassword());
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(existedUser);
    }
}
