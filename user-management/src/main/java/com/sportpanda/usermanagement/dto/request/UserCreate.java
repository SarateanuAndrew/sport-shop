package com.sportpanda.usermanagement.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserCreate(@NotBlank String username, @NotBlank String password, @NotBlank String firstName,
                         @NotBlank String lastName, @NotBlank String email, @NotBlank String phone) {
}
