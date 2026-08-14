package ua.raghoulwave.bergut_api.dto.register;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record RegisterResponse(

        @NotBlank
        UUID id,

        @NotBlank
        String username,

        @NotBlank
        String email,

        String firstname,
        String lastname
) {}
