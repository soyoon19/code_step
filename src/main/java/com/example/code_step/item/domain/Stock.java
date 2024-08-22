package com.example.code_step.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Stock {
    private Long id;

    private Inventory inventory;

    private int count;

    private Item item;

    public boolean remind(){
        return count > 0 ? true : false;
    }

    public boolean decrease(){
        if(!remind()) return false;
        count--;
        return true;
    }

    public boolean increase(){
        count++;
        return true;
    }
}
