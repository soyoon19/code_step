package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;

public class ExpBuff implements Item{
    private float factor;

    @Override
    public void use(Member member) {
        member.setBuffFactor(factor);
    }

    @Override
    public long getItemId() {
        return 0;
    }
}
