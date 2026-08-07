package ua.raghoulwave.bergut_api.strava.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ua.raghoulwave.bergut_api.strava.property.StravaProperties;

@Configuration
@EnableConfigurationProperties(StravaProperties.class)
public class StravaConfig {
}
