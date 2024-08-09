package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;

public class MultipleChoiceProblem implements Problem{

    private Choice answer;
    private Compensation compensation;

    @Override
    public boolean tellAnswer(Choice[] choices, Member member) {
        if(choices[0].getId() == answer.getId()) {
            member.addCompensation(compensation);
            return true;
        }
        member.decreaseHeart();
        return false;
    }

    @Override
    public Object tellCompensation() {
        return null;
    }
}
