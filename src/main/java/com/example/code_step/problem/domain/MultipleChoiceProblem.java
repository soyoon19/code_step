package com.example.code_step.problem.domain;

public class MultipleChoiceProblem implements Problem{

    private Choice answer;

    @Override
    public boolean tellAnswer(Choice[] choices) {
        if(choices[0].getId() == answer.getId()) return true;
        return false;
    }

    @Override
    public Object tellCompensation() {
        return null;
    }
}
