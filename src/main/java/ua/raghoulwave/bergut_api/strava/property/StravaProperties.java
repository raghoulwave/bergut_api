package ua.raghoulwave.bergut_api.strava.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bergut.config.strava")
public record StravaProperties(
        String clientId,
        String clientSecret,
        String redirectUri
) {}
