package com.sportpanda.usermanagement.services;

import com.sportpanda.usermanagement.dto.request.OrderCreateRequest;

import java.util.UUID;

public interface OrderService {

    void createOrder(OrderCreateRequest request, UUID userId);
}
