package com.sportpanda.productsservice.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductsResponse(UUID id, String name, BigDecimal price) {
}
