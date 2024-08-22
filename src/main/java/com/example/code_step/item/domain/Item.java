package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;

public interface Item {
    void use(Member member);
    String getItemId();
    Compensation getCompensation();
}
