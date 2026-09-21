package com.fnb.orderservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDto {
    private Long customerId;
    List<OrderItemRequestDto> items;
}
