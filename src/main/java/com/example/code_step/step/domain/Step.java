package com.example.code_step.step.domain;

import com.example.code_step.problem.domain.Compensation;
import com.example.code_step.problem.domain.Problem;

import java.util.List;

public class Step implements Staged<Problem>{
    List<Problem> list;

    public Compensation getCompensation() {
        return null;
    }

    @Override
    public List<Problem> showStage() {
        return list;
    }
}

