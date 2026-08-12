package ua.raghoulwave.bergut_api.mapper;

import org.mapstruct.*;
import ua.raghoulwave.bergut_api.entity.OAuthAccount;
import ua.raghoulwave.bergut_api.strava.dto.StravaTokenResponse;

@Mapper(componentModel = "spring")
public interface OAuthAccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "providerUserId", source = "athlete.id")
    @Mapping(target = "accessToken", source = "access_token")
    @Mapping(target = "refreshToken", source = "refresh_token")
    @Mapping(target = "expiresAt", source = "expires_at")
    @Mapping(target = "expiresIn", source = "expires_in")
    @Mapping(target = "scope", source = "scope")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "version", ignore = true)
    OAuthAccount toEntity(StravaTokenResponse dto);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "providerUserId", source = "athlete.id")
    @Mapping(target = "accessToken", source = "access_token")
    @Mapping(target = "refreshToken", source = "refresh_token")
    @Mapping(target = "expiresAt", source = "expires_at")
    @Mapping(target = "expiresIn", source = "expires_in")
    @Mapping(target = "scope", source = "scope")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "version", ignore = true)
    void update(StravaTokenResponse dto, @MappingTarget OAuthAccount entity);
}
