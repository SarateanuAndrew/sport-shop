package com.sportpanda.usermanagement.controllers;

import com.sportpanda.usermanagement.dto.request.UserCreate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-management")
public class UserRegistryController {


    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserCreate request) {
        //todo add user
    }
}
