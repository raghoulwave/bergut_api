package ua.raghoulwave.bergut_api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.raghoulwave.bergut_api.constants.Provider;
import ua.raghoulwave.bergut_api.entity.OAuthAccount;
import ua.raghoulwave.bergut_api.mapper.OAuthAccountMapper;
import ua.raghoulwave.bergut_api.repository.OAuthAccountRepository;
import ua.raghoulwave.bergut_api.dto.strava.StravaTokenResponse;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OAuthAccountService {

    private final OAuthAccountRepository repository;
    private final OAuthAccountMapper mapper;

    public List<OAuthAccount> getAll() {
        return repository.findAll();
    }

    public OAuthAccount getOrCreate(StravaTokenResponse dto) {

        return repository.findByProviderUserId(dto.athlete().id())
                .map(existing -> {
                    mapper.update(dto, existing);
                    existing.setUpdatedAt(Instant.now());
                    existing.setVersion(existing.getVersion() + 1L);
                    log.info(
                            "Updated existing OAuth Account {} ({}) at {}",
                            existing.getProviderUserId(),
                            existing.getProvider(),
                            existing.getUpdatedAt()
                    );
                    return repository.save(existing);
                })
                .orElseGet(() -> {
                   OAuthAccount entity = mapper.toEntity(dto);
                   entity.setUserId(UUID.randomUUID());
                   entity.setProvider(Provider.STRAVA);
                   entity.setVersion(1L);
                   log.info(
                           "Created new OAuth Account {} ({}) at {}",
                           entity.getProviderUserId(),
                           entity.getProvider(),
                           entity.getCreatedAt()
                   );
                   return repository.save(entity);
                });
    }
}
