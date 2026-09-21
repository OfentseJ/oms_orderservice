package com.fnb.orderservice.service;

import com.fnb.orderservice.dto.InventoryItemRequestDto;
import com.fnb.orderservice.dto.InventoryItemResponseDto;

public interface InventoryService {
    InventoryItemResponseDto addInventoryItem(InventoryItemRequestDto inventoryItemRequestDto);
}
