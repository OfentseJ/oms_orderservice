package com.fnb.orderservice.service.serviceImpl;

import com.fnb.orderservice.dto.InventoryItemRequestDto;
import com.fnb.orderservice.dto.InventoryItemResponseDto;
import com.fnb.orderservice.entity.InventoryItem;
import com.fnb.orderservice.repository.InventoryItemRepository;
import com.fnb.orderservice.service.InventoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryItemRepository inventoryItemRepository;

    @Override
    @Transactional
    public InventoryItemResponseDto addInventoryItem(InventoryItemRequestDto inventoryItemRequestDto) {

        InventoryItem inventoryItem = InventoryItem.builder()
                .itemName(inventoryItemRequestDto.getItemName())
                .description(inventoryItemRequestDto.getDescription())
                .price(inventoryItemRequestDto.getPrice())
                .stockQuantity(inventoryItemRequestDto.getStockQuantity())
                .build();
        inventoryItem = inventoryItemRepository.save(inventoryItem);

        return toUserResponse(inventoryItem);
    }

    private InventoryItemResponseDto toUserResponse(InventoryItem inventoryItem) {
        return InventoryItemResponseDto.builder()
                .itemId(inventoryItem.getItemId())
                .itemName(inventoryItem.getItemName())
                .description(inventoryItem.getDescription())
                .price(inventoryItem.getPrice())
                .stockQuantity(inventoryItem.getStockQuantity())
                .build();
    }
}
