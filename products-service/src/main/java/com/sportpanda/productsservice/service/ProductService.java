package com.sportpanda.productsservice.service;

import com.sportpanda.productsservice.dto.response.ProductsResponse;
import com.sportpanda.productsservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductsResponse> productInfo(Set<UUID> request) {
        return productRepository.findAllByIdIn(request).stream()
                .map(e -> new ProductsResponse(e.getId(), e.getName(), e.getPrice()))
                .toList();
    }

}
