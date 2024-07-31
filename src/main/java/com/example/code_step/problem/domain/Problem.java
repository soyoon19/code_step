package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;

public interface Problem {
    boolean tellAnswer(Choice[] choices, Member member);
    Object tellCompensation();
}
