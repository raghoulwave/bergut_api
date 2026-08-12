package ua.raghoulwave.bergut_api.strava.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;
import ua.raghoulwave.bergut_api.strava.dto.StravaTokenResponse;
import ua.raghoulwave.bergut_api.strava.property.StravaProperties;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class StravaOAuthService {

    private final StravaProperties properties;
    private final RestClient restClient;

    public URI getAuthorizationUri() {

        int clientId = Integer.parseInt(properties.clientId());

        return UriComponentsBuilder
                .fromUriString("https://www.strava.com/oauth/authorize")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", properties.redirectUri())
                .queryParam("response_type", "code")
                .queryParam("approval_prompt", "force")
                .queryParam("scope", "read_all,profile:read_all,activity:read_all")
                .queryParam("state", UUID.randomUUID()) // to fix
                .build()
                .toUri();
    }

    public StravaTokenResponse exchangeCode(String code) {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("client_id", properties.clientId());
        body.add("client_secret", properties.clientSecret());
        body.add("code", code);
        body.add("grant_type", "authorization_code");

        return restClient.post()
                .uri("https://www.strava.com/oauth/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(body)
                .retrieve()
                .body(StravaTokenResponse.class);
    }
}
