package com.sportpanda.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderProducts {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private UserOrder order;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private String productName;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
