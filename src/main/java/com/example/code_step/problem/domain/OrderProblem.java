package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record OrderProblem(List<Choice> allChoices, List<Choice> answerOrders, ProblemBasicInfo problemBasicInfo) implements Problem {
    @Override
    public boolean tellAnswer(List<Choice> choices, Member member) {
        if(choices.size() != answerOrders.size()){
            member.decreaseHeart();
            return false;
        }

        Collections.sort(choices, (c1, c2) -> Math.toIntExact(c1.id() - c2.id()));

        for (int i = 0; i < answerOrders.size(); i++)
            if (answerOrders.get(i).id() != choices.get(i).id()
            || !choices.get(i).answer()) {
                member.decreaseHeart();
                return false;
            }

        return true;
    }


    public OrderProblem(List<Choice> allChoices, List<Choice> answerOrders, ProblemBasicInfo problemBasicInfo) {
        this.allChoices = allChoices;
        this.problemBasicInfo = problemBasicInfo;

        if(answerOrders.isEmpty()){
            for(Choice choice : allChoices)
                if(choice.answer())
                    answerOrders.add(choice);
        }
        this.answerOrders = answerOrders;
    }

    @Builder
    public OrderProblem(List<Choice> allChoices, ProblemBasicInfo problemBasicInfo) {
        this(allChoices, Collections.emptyList(), problemBasicInfo);
    }

    //문제를 사용자에게 제줄 때 선택지를 섞어 보여줌
    public OrderProblem mixChoice() {
        List<Choice> tmp = new ArrayList<>(allChoices);
        Collections.shuffle(tmp);

        return OrderProblem.builder()
                .allChoices(allChoices)
                .problemBasicInfo(problemBasicInfo)
                .build();
    }

}
