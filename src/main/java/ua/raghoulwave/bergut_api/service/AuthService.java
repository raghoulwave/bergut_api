package ua.raghoulwave.bergut_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.raghoulwave.bergut_api.dto.RegisterRequest;
import ua.raghoulwave.bergut_api.dto.UserResponse;
import ua.raghoulwave.bergut_api.entity.User;
import ua.raghoulwave.bergut_api.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponse register(RegisterRequest request) {

        if(repository.existsByUsername(request.username())) {
            throw new IllegalArgumentException(
                    "Username already taken"
            );
        }

        if(repository.existsByEmail(request.email())) {
            throw new IllegalArgumentException(
                    "Email already registered"
            );
        }

        if(!isPasswordValid(request.password())) {
            throw new IllegalArgumentException(
                    "Password is invalid"
            );
        }

        return new UserResponse(
                request.username(),
                request.email(),
                request.password(),
                request.firstname(),
                request.lastname()
        );
    }

    private boolean isPasswordValid(String password) {
        return true;
    }
}
