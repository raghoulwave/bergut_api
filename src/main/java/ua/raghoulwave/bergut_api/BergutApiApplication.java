package ua.raghoulwave.bergut_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ua.raghoulwave.bergut_api.property.strava.StravaProperties;

@SpringBootApplication
@EnableConfigurationProperties(StravaProperties.class)
public class BergutApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BergutApiApplication.class, args);
    }
}
