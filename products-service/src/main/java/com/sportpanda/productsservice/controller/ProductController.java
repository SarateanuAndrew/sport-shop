package com.sportpanda.productsservice.controller;

import com.sportpanda.productsservice.dto.response.ProductsResponse;
import com.sportpanda.productsservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/info-product")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsResponse> productInfo(@RequestBody Set<UUID> request) {
        return productService.productInfo(request);
    }
}
