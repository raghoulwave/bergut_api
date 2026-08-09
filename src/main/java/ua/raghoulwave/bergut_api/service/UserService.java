package ua.raghoulwave.bergut_api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.raghoulwave.bergut_api.entity.User;
import ua.raghoulwave.bergut_api.repository.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public User getOrCreate() {

         return null;
    }
}
