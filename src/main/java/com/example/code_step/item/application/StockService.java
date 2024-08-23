package com.example.code_step.item.application;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.Item;
import com.example.code_step.item.domain.Stock;
import com.example.code_step.item.domain.repository.StockRepository;
import com.example.code_step.item.infrastructure.StockJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final ItemService itemService;

    public Stock findById(Long id, Inventory inventory, Item item) {
        return stockRepository.findById(id).toModel(inventory, item);
    }


    public boolean save(Stock stock) {
        return stockRepository.save(StockJpaEntity.from(stock));
    }

    public List<Stock> findByInventory(Inventory inventory) {
        List<StockJpaEntity> stockJpaEntities = stockRepository.findByInventoryId(inventory.getId());
        List<Stock> stocks = new ArrayList<>();

        //음... 코드가 마음에 안 든다.
        for (StockJpaEntity stockJpaEntity : stockJpaEntities)
            stocks.add(stockJpaEntity.toModel(inventory,
                    itemService.findById(stockJpaEntity.getItemId())));

        return stocks;
    }
}
