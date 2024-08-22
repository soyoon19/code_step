package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;

@Getter
@Builder
public class Inventory {
    private Long id;

    private HashMap<String, Stock> inventory = new HashMap<>();

    public boolean findItem(Item item) {
        return inventory.get(item.getItemId()) != null;
    }

    public void useItem(Item item, Member member) {
        //Todo : 추후 예외 처리
        Stock stock = inventory.get(item.getItemId());

        stock.decrease();
        item.use(member);

        if (!stock.remind())
            inventory.remove(item.getItemId());
    }

    public void plusItem(Item item) {
        Stock stock = inventory.get(item.getItemId());
        if(stock == null)
            stock = Stock.builder()
                    .item(item)
                    .count(1)
                    .inventory(this)
                    .build();
        else
            stock.increase();

        inventory.put(item.getItemId(), stock);
    }


    public void putStock(Stock stock) {
        inventory.put(stock.getItem().getItemId(), stock);
    }

}
