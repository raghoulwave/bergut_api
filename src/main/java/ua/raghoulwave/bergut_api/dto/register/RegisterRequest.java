package ua.raghoulwave.bergut_api.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank
        @Size(
                min = 6,
                max = 32
        )
        String username,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(
                min = 16,
                max = 32
        )
        String password,

        String firstname,
        String lastname
) {}
