package com.example.code_step.step.domain;

import com.example.code_step.problem.domain.Problem;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Step implements Staged<Problem>{
    protected Compensation compensation;

    protected long unitId;
    protected long id;
    protected int order;
}

