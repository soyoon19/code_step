package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;

import java.util.List;

public interface Problem {
    boolean tellAnswer(List<Choice> choices, Member member);
}
