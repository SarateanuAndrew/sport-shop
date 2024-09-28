package com.sportpanda.usermanagement.repository;

import com.sportpanda.usermanagement.entity.UsersRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersRegistry, UUID> {
}
