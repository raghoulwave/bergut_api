package ua.raghoulwave.bergut_api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.raghoulwave.bergut_api.entity.User;
import ua.raghoulwave.bergut_api.repository.UserRepository;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public User getById(UUID id) {
        if(repository.existsById(id)) {
            return repository.findById(id).orElseThrow(() ->
                    new UsernameNotFoundException(
                            "User not found"
                    )
            );
        }
        throw new UsernameNotFoundException(
                "User not found"
        );
    }

    public User getByUsernameOrEmail(String query) {
        if(repository.existsByUsername(query)) {
            return repository.findByUsername(query).orElseThrow(() ->
                    new UsernameNotFoundException(
                            "User not found"
                    )
            );
        } else if(repository.existsByEmail(query)) {
            return repository.findByEmail(query).orElseThrow(() ->
                    new UsernameNotFoundException(
                            "User not found"
                    )
            );
        }
        throw new UsernameNotFoundException(
                "User not found"
        );
    }

    public User getByUsername(String username) {
        if(repository.existsByUsername(username)) {
            return repository.findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException(
                            "User not found"
                    )
            );
        }
        throw new UsernameNotFoundException(
                "User not found"
        );
    }

    public User getByEmail(String email) {
        if(repository.existsByEmail(email)) {
            return repository.findByEmail(email).orElseThrow(() ->
                    new UsernameNotFoundException(
                            "User not found"
                    )
            );
        }
        throw new UsernameNotFoundException(
                "User not found"
        );
    }

    public User save(User user) {
        return repository.save(user);
    }
}
