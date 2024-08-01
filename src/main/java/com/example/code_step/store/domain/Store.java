package com.example.code_step.store.domain;

import com.example.code_step.item.domain.Item;
import com.example.code_step.member.domain.Member;

public class Store {
    public Boolean settItem(Member member, Item item) {
        if(!member.availabilityBuy(item.getCompensation()))
            return false;

        member.getInventory().addItem(item);
        return true;
    }
}
