package com.example.code_step.step.domain;

import com.example.code_step.problem.domain.Problem;

import java.util.List;

public class Step {
    List<Problem> list;
    public List<Problem> showProblem(){return list;}
    public int givePoint(){return 1;}
    public int giveMoney(){return 1;}
}
