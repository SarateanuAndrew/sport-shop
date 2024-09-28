package com.sportpanda.usermanagement.services;

import com.sportpanda.usermanagement.dto.request.UserCreate;

public interface UserManagementService {

    void createUser(UserCreate request);
}
