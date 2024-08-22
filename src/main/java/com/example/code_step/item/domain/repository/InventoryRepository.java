package com.example.code_step.item.domain.repository;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.infrastructure.InventoryJpaEntity;
import org.springframework.stereotype.Component;

@Component
public interface InventoryRepository {
    InventoryJpaEntity findById(Long id);
    boolean save(InventoryJpaEntity inventory);
    void deleteById(Long id);
}
