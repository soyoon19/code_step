package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {
    private final InventoryJpaRepository inventoryJpaRepository;


    @Override
    public InventoryJpaEntity findById(Long id) {
        return inventoryJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(InventoryJpaEntity inventory) {
        return inventoryJpaRepository.save(inventory) != null;
    }

    @Override
    public void deleteById(Long id) {
        inventoryJpaRepository.deleteById(id);
    }
}
