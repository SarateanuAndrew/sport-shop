package com.sportpanda.usermanagement.repository;

import com.sportpanda.usermanagement.entity.OrderProducts;
import com.sportpanda.usermanagement.entity.UsersRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<OrderProducts, UUID> {
}
