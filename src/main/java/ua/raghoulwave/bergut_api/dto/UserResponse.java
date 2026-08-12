package ua.raghoulwave.bergut_api.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserResponse(

        @NotBlank
        String username,

        @NotBlank
        String email,

        @NotBlank
        String password,

        String firstname,
        String lastname
) {}
