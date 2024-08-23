package com.example.code_step.store.domain;

import com.example.code_step.item.domain.Item;
import com.example.code_step.member.domain.Member;

public class Store {
    public Boolean sellItem(Member member, Item item) {
        if(!member.availabilityBuy(item.getCompensation()))
            return false;

        member.minusCompensation(item.getCompensation());

        member.getInventory().plusItem(item);
        return true;
    }
}
