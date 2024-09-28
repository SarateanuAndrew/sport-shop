package com.sportpanda.usermanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.UUID;

public record OrderCreateRequest(
        @NotNull Map<UUID, Long> products,
        @NotBlank String address,
        String comments
) {
}
