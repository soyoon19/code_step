package com.example.code_step.problem.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.member.domain.Member;
import com.example.code_step.problem.domain.Choice;
import com.example.code_step.problem.domain.Problem;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl  {
    public CommonResult problemSolve(Problem problem, Choice[] choice, Member member) {
        if(member.isDie())
            return CommonResult.builder()
                    .code(-1)
                    .message("already dead")
                    .success(false)
                    .build();

        Boolean answer = problem.tellAnswer(choice, member);

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
