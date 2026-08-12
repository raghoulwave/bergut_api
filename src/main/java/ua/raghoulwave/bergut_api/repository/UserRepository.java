package ua.raghoulwave.bergut_api.repository;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.raghoulwave.bergut_api.constants.Role;
import ua.raghoulwave.bergut_api.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByRole(Role role);

    Optional<User> findByEmail(@NonNull String email);
    boolean existsByEmail(@NonNull String email);

    Optional<User> findByUsername(@NonNull String email);
    boolean existsByUsername(@NonNull String username);
}
