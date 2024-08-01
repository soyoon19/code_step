package com.example.code_step.item.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.problem.domain.Compensation;

public interface Item {
    void use(Member member);
    long getItemId();
    Compensation getCompensation();
}
