package com.example.code_step.problem.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.step.domain.Compensation;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;

public record MultipleChoiceProblem(List<Choice> answer, ProblemBasicInfo problemBasicInfo) implements Problem{

    @Override
    public boolean tellAnswer(List<Choice> choices, Member member) {
        if(choices.size() != answer.size())  { //사용자가 선택한 선택지와 정답의 개수가 다른 경우
            member.decreaseHeart();
            return false;
        }

        //아이디 순서로 정렬
        Collections.sort(choices, (c1, c2) -> Math.toIntExact(c1.id() - c2.id()));

        //선택한 선택지와 정답과 맞는지 확인
        for(int i = 0; i < answer.size(); i++)
            if(choices.get(i).id() != answer.get(i).id()) {
                member.decreaseHeart();
                return false;
            }


        return true;
    }


    //초기화할 때 문제의 정답을 id 순으로 정렬한다.
    @Builder
    public MultipleChoiceProblem(List<Choice> answer, ProblemBasicInfo problemBasicInfo) {
        Collections.sort(answer, (c1, c2) -> Math.toIntExact(c1.id() - c2.id()));
        this.answer = answer;
        this.problemBasicInfo = problemBasicInfo;
    }
}
