package ua.raghoulwave.bergut_api.dto.strava;

public record StravaAthlete (
        Long id,
        String username,
        Integer resource_state,
        String firstname,
        String lastname,
        String bio,
        String city,
        String state,
        String country,
        String sex,
        Boolean premium,
        Boolean summit,
        String created_at,
        String updated_at,
        Integer badge_type_id,
        String profile_medium,
        String profile,
        Integer friend,
        Integer follower
) {}
