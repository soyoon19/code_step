package com.example.code_step.item.application;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.Stock;
import com.example.code_step.item.domain.repository.InventoryRepository;
import com.example.code_step.item.infrastructure.InventoryJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final StockService stockService;

    public Inventory findById(Long id) {
        return inventoryRepository.findById(id).toModel();
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(InventoryJpaEntity.from(inventory)).toModel();
    }

    //DB 정보를 가져와 인벤토리 초기화
    public Inventory inventoryInit(Inventory inventory) {
        List<Stock> stocks = stockService.findByInventory(inventory);
        for (Stock stock : stocks)
            inventory.putStock(stock);

        return inventory;
    }
}
