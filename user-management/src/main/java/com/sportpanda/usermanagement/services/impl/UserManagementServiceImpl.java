package com.sportpanda.usermanagement.services.impl;

import com.sportpanda.usermanagement.dto.request.UserCreate;
import com.sportpanda.usermanagement.entity.UsersRegistry;
import com.sportpanda.usermanagement.repository.UserRepository;
import com.sportpanda.usermanagement.services.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserCreate request) {
        UsersRegistry user = UsersRegistry.builder()
                .password(request.password())
                .username(request.username())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .build();
        userRepository.save(user);
    }
}
