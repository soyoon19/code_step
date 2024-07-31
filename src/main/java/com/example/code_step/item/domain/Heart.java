package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;

public class Heart implements Item{

    @Override
    public void use(Member member) {
        member.increaseHeart(1);
    }

    @Override
    public long getItemId() {
        return 0;
    }
}
