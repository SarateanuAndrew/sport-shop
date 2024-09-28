package com.sportpanda.productsservice.repository;

import com.sportpanda.productsservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByIdIn(Set<UUID> ids);
}
