package com.sportpanda.usermanagement.services.impl;

import com.sportpanda.usermanagement.dto.request.OrderCreateRequest;
import com.sportpanda.usermanagement.dto.response.ProductsResponse;
import com.sportpanda.usermanagement.entity.OrderProducts;
import com.sportpanda.usermanagement.entity.UserOrder;
import com.sportpanda.usermanagement.entity.UsersRegistry;
import com.sportpanda.usermanagement.enums.OrderStatus;
import com.sportpanda.usermanagement.repository.OrderRepository;
import com.sportpanda.usermanagement.repository.ProductRepository;
import com.sportpanda.usermanagement.repository.UserRepository;
import com.sportpanda.usermanagement.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Override
    @Transactional(timeout = 5)
    public void createOrder(OrderCreateRequest request, UUID userId) {
        UsersRegistry user = userRepository.findById(userId).orElseThrow();
        UserOrder order = UserOrder.builder()
                .status(OrderStatus.PENDING)
                .usersRegistry(user)
                .build();
        orderRepository.save(order);

        Set<UUID> keySet = request.products().keySet();

        ProductsResponse[] productsResponses = restTemplate.postForObject(
                "http://PRODUCTS-SERVICE/api/products/info-product",
                keySet,
                ProductsResponse[].class);

        if (productsResponses != null && productsResponses.length > 0) {
            List<OrderProducts> orderProducts = Arrays.stream(productsResponses).map(ps -> OrderProducts.builder()
                            .productId(ps.id())
                            .quantity(request.products().get(ps.id()))
                            .productName(ps.name())
                            .order(order)
                            .unitPrice(ps.price())
                            .build())
                    .toList();

            productRepository.saveAll(orderProducts);
        }

    }
}
