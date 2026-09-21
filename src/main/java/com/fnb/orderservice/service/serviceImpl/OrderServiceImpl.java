package com.fnb.orderservice.service.serviceImpl;

import com.fnb.orderservice.dto.OrderRequestDto;
import com.fnb.orderservice.dto.OrderResponseDto;
import com.fnb.orderservice.repository.OrderRepository;
import com.fnb.orderservice.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        return null;
    }
}
