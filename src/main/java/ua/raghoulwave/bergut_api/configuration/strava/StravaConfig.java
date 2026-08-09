package ua.raghoulwave.bergut_api.configuration.strava;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ua.raghoulwave.bergut_api.property.strava.StravaProperties;

@Configuration
@EnableConfigurationProperties(StravaProperties.class)
public class StravaConfig {
}
