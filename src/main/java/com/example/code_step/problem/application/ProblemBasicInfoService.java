package com.example.code_step.problem.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.domain.Member;
import com.example.code_step.problem.application.repository.ProblemRepository;
import com.example.code_step.problem.domain.*;
import com.example.code_step.problem.infrastructure.ChoiceJpaEntity;
import com.example.code_step.problem.presentation.dto.ProblemAndChoicesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ProblemBasicInfoService {
    private final ChoiceService choiceService;
    private final MemberService memberService;
    ProblemRepository problemRepository;

    public ProblemBasicInfo findById(Long id) {
        return problemRepository.findById(id).toModel();
    }

    public boolean save(ProblemBasicInfo problemBasicInfo) {
        return save(problemBasicInfo);
    }

    public CommonResult addProblem(ProblemAndChoicesDto problemAndChoicesRequestDto) {
        return null;
    }

    public Problem getProblemById(Long problemId) {
        ProblemBasicInfo problemBasicInfo = findById(problemId); //문제 정보 가져오기
        List<Choice> choices = choiceService.findByProblemId(problemId); //문제와 연결되어 있는 선택지 모두 가져오기

        List<Choice> answer = new ArrayList<>(); //정답 가져오기
        for(Choice choice : choices)
            if(choice.answer())
                answer.add(choice);

        switch (problemBasicInfo.type()){
            case ProblemBasicInfo.MULTIPLE_CHOICE_PROBLEM:
                return MultipleChoiceProblem.builder()
                        .problemBasicInfo(problemBasicInfo)
                        .answer(answer)
                        .build();

            case ProblemBasicInfo.ORDER_PROBLEM:
                return OrderProblem.builder()
                        .problemBasicInfo(problemBasicInfo)
                        .allChoices(choices)
                        .build();
        }

        return null;
    }

    public CommonResult problemSolve(Long problemId, List<Long> choiceIds, String uid) {
        Member member = memberService.findByUid(uid);
        Problem problem = getProblemById(problemId);

        if(member.isDie())
            return CommonResult.builder()
                    .code(-1)
                    .message("already dead")
                    .success(false)
                    .build();


        List<Choice> choices = new ArrayList<>();
        for(Long choiceId : choiceIds)
            choices.add(choiceService.findChoice(choiceId));


        Boolean answer = problem.tellAnswer(choices, member);

        if(member.isDie())
            return CommonResult.builder()
                    .code(2)
                    .message("die")
                    .success(true)
                    .build();

        return CommonResult.builder()
                .code(1)
                .message(answer.toString())
                .success(true)
                .build();
    }
}
