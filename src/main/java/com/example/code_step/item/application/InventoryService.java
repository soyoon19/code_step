package com.example.code_step.item.application;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Inventory findById(Long id) {
        Inventory inventory = inventoryRepository.findById(id).toModel();
        return inventory;
    }

    //인벤토리 초기화
    public Inventory inventoryInit(Inventory inventory) {

    }
}
