package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;

public class Heart implements Item{
    private String id;
    private Compensation compensation;

    @Override
    public void use(Member member) {
        member.increaseHeart(1);
    }

    @Override
    public String getItemId() {
        return id;
    }

    @Override
    public Compensation getCompensation() {
        return null;
    }
}
