package com.fnb.orderservice.repository;

import com.fnb.orderservice.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<InventoryItem, Long> {
}
