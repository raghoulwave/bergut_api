package ua.raghoulwave.bergut_api.strava.dto;

public record StravaTokenResponse (
        String token_type,
        String access_token,
        String refresh_token,
        Long expires_at,
        Long expires_in,
        String scope
) {}
