package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.problem.domain.Compensation;

public class Heart implements Item{
    private Compensation compensation;

    @Override
    public void use(Member member) {
        member.increaseHeart(1);
    }

    @Override
    public long getItemId() {
        return 0;
    }

    @Override
    public Compensation getCompensation() {
        return null;
    }
}
