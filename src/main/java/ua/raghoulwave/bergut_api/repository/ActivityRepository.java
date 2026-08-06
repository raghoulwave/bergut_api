package ua.raghoulwave.bergut_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.raghoulwave.bergut_api.constants.SportType;
import ua.raghoulwave.bergut_api.entity.Activity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    Optional<Activity> findByProviderActivityId(UUID providerActivityId);

    List<Activity> findByUserId(UUID userId);

    List<Activity> findBySportType(SportType sportType);
}
