package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;

import java.util.HashMap;

public class Inventory {
    private HashMap<Long, Stock> inventory = new HashMap<>();

    public boolean findItem(Item item) {
        return inventory.get(item.getItemId()) != null;
    }

    public void useItem(Item item, Member member) {
        //Todo : 추후 예외 처리
        Stock stock = inventory.get(item.getItemId());
        //if(stock == null)

        stock.setCount(stock.getCount() - 1);

        if (stock.getCount() == 0)
            inventory.remove(item.getItemId());
    }

    public void addItem(Item item) {
        Stock stock = inventory.get(item.getItemId());
        if(stock == null)
            stock = new Stock(1, item);
        else
            stock.setCount(stock.getCount() + 1);

        inventory.put(item.getItemId(), stock);
    }
}
