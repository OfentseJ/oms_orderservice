package com.fnb.orderservice.dto;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Long orderItemId;
    private int quantity;
}
