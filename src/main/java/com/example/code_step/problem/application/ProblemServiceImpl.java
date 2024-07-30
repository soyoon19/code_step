package com.example.code_step.problem.application;

import com.example.code_step.problem.domain.Choice;
import com.example.code_step.problem.domain.Problem;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {


    @Override
    public boolean problemSolve(long problemId, long choiceId) {
        return false;
    }
}
