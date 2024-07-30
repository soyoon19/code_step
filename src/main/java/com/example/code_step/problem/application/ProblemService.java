package com.example.code_step.problem.application;

import com.example.code_step.problem.domain.Choice;
import com.example.code_step.problem.domain.Problem;

public interface ProblemService {
    boolean problemSolve(long problemId, long choiceId);
}
