package com.example.code_step.problem.domain;

public class OrderProblem implements Problem{
    private Choice[] answerOrders;

    @Override
    public boolean tellAnswer(Choice[] choices) {
        for(int i = 0; i < answerOrders.length; i++)
            if(answerOrders[i].getId() != choices[i].getId())
                return false;

        return true;
    }

    @Override
    public Object tellCompensation() {
        return null;
    }
}
