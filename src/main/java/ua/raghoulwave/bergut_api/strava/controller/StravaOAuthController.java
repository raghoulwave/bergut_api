package ua.raghoulwave.bergut_api.strava.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.raghoulwave.bergut_api.service.OAuthAccountService;
import ua.raghoulwave.bergut_api.strava.dto.StravaTokenResponse;
import ua.raghoulwave.bergut_api.strava.service.StravaOAuthService;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/providers/strava")
@RequiredArgsConstructor
public class StravaOAuthController {

    private final StravaOAuthService stravaOAuthService;
    private final OAuthAccountService oAuthAccountService;

    @GetMapping("/connect")
    public ResponseEntity<Void> connect() { // perhaps shouldn't be void??

        URI uri = stravaOAuthService.getAuthorizationUri();

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(uri)
                .build();
    }

    @GetMapping("/callback")
    public StravaTokenResponse callback(
            @RequestParam String code
    ) {
        StravaTokenResponse response = stravaOAuthService.exchangeCode(code);

        oAuthAccountService.getOrCreate(response);

        return response;
    }
}
