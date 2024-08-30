package com.example.code_step.member.presentation;

import com.example.code_step.core.CommonResult;
import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.presentation.dto.MemberJoinRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @PostMapping("/join")
    public CommonResult join(@RequestBody  MemberJoinRequestDto memberInfo) {

        memberService.join(memberInfo);
        System.out.println("memberInfo : " + memberInfo.toString());
        System.out.println("join!");

        return CommonResult.builder()
                .code(200)
                .message("join success")
                .success(true)
                .build();
    }

    @GetMapping("/member")
    public Boolean exists(HttpServletRequest request){
        return memberService.exists((String) request.getAttribute("uid"));
    }



}
