package ua.raghoulwave.bergut_api.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        
   String username,

   @Email
   String email,

   @NotBlank
   String password
) {}
