package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;

public class OrderProblem implements Problem{

    private Choice[] answerOrders;
    Compensation compensation;

    @Override
    public boolean tellAnswer(Choice[] choices, Member member) {
        for(int i = 0; i < answerOrders.length; i++)
            if(answerOrders[i].getId() != choices[i].getId()) {
                member.decreaseHeart();
                return false;
            }

        member.addCompensation(compensation);
        return true;
    }

    @Override
    public Object tellCompensation() {
        return null;
    }
}
