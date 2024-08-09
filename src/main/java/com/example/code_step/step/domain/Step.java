package com.example.code_step.step.domain;

import com.example.code_step.problem.domain.Compensation;
import com.example.code_step.problem.domain.Problem;
import lombok.Getter;

import java.util.List;

@Getter
public class Step implements Staged<Problem>{
    protected Compensation compensation;

    protected long unitId;
    protected long id;
    protected long order;
}

