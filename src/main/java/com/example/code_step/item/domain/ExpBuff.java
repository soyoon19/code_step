package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;

public class ExpBuff implements Item{
    private float factor;
    private Compensation compensation;

    @Override
    public void use(Member member) {
        member.setBuffFactor(factor);
    }

    @Override
    public long getItemId() {
        return 0;
    }

    @Override
    public Compensation getCompensation() {
        return compensation;
    }
}
