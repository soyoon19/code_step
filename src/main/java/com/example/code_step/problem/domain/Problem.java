package com.example.code_step.problem.domain;

public interface Problem {
    boolean tellAnswer(Choice[] choices);
    Object tellCompensation();
}
