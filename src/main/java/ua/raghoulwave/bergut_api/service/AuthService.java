package ua.raghoulwave.bergut_api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.raghoulwave.bergut_api.dto.register.RegisterRequest;
import ua.raghoulwave.bergut_api.dto.register.RegisterResponse;
import ua.raghoulwave.bergut_api.entity.User;
import ua.raghoulwave.bergut_api.mapper.UserMapper;
import ua.raghoulwave.bergut_api.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public RegisterResponse register(RegisterRequest request) {

        if(userRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException(
                    "Username already taken"
            );
        }

        if(userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException(
                    "Email already registered"
            );
        }

        if(!isPasswordValid(request.password())) {
            throw new IllegalArgumentException(
                    "Password is invalid"
            );
        }

        User user = userService.save(userMapper.registerRequestToEntity(request));

        return new RegisterResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname()
        );
    }

    private boolean isPasswordValid(String password) {
        return true;
    }
}
