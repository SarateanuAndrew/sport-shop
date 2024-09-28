package com.sportpanda.usermanagement.controllers;

import com.sportpanda.usermanagement.dto.request.OrderCreateRequest;
import com.sportpanda.usermanagement.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-management")
public class UserOrderController {

    private final OrderService orderService;

    @PostMapping("/add-order")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody @Valid OrderCreateRequest request) {
        orderService.createOrder(request, UUID.fromString("4372c25f-e30a-4d8e-b6f1-575b6f8eef68"));
    }

    @GetMapping("/history-order")
    @ResponseStatus(HttpStatus.OK)
    public void historyOrder() {
        //todo get user order history
    }
}
