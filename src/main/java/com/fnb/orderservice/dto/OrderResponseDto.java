package com.fnb.orderservice.dto;

import com.fnb.orderservice.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private BigDecimal totalAmount;
}
