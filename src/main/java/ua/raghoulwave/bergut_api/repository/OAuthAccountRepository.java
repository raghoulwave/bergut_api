package ua.raghoulwave.bergut_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.raghoulwave.bergut_api.constants.Provider;
import ua.raghoulwave.bergut_api.entity.OAuthAccount;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OAuthAccountRepository extends JpaRepository<OAuthAccount, UUID> {

    Optional<OAuthAccount> findByUserId(UUID userId);

    Optional<OAuthAccount> findByProviderUserId(UUID providerUserId);

    List<OAuthAccount> findByProvider(Provider provider);
}
