package com.example.code_step.step.domain;

import com.example.code_step.problem.domain.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Step implements Staged<Problem>{
    protected Compensation compensation;

    protected long unitId;
    protected long id;
    protected int order;
}
