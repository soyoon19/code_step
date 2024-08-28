package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.Item;
import com.example.code_step.item.domain.Stock;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "stock")
public class StockJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long inventoryId;

    private Integer count;

    private String itemId;

    @Builder
    public StockJpaEntity(Long id, Long inventoryId, Integer count, String itemId) {
        this.id = id;
        this.inventoryId = inventoryId;
        this.count = count;
        this.itemId = itemId;
    }

    public Stock toModel(Inventory inventory, Item item){
        return Stock.builder()
                .inventory(inventory)
                .count(count)
                .item(item)
                .id(id)
                .build();
    }

    public static StockJpaEntity from(Stock stock){
        return StockJpaEntity.builder()
                .id(stock.getId())
                .inventoryId(stock.getInventory().getId())
                .count(stock.getCount())
                .itemId(stock.getItem().getItemId())
                .build();
    }

}
