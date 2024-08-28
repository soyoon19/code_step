package com.example.code_step.member.presentation;

import com.example.code_step.core.CommonResult;
import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.presentation.dto.MemberJoinRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/join")
    public CommonResult join(MemberJoinRequestDto memberInfo) {
        memberService.join(memberInfo);

        return CommonResult.builder()
                .code(200)
                .message("join success")
                .success(true)
                .build();
    }
}
