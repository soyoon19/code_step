package com.example.code_step.problem.presentation;

import com.example.code_step.core.CommonResult;
import com.example.code_step.problem.application.ProblemBasicInfoService;
import com.example.code_step.problem.domain.Problem;
import com.example.code_step.problem.domain.ProblemBasicInfo;
import com.example.code_step.problem.presentation.dto.ProblemDto;
import com.example.code_step.problem.presentation.dto.ProblemSolveDto;
import jakarta.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProblemController {
    private final ProblemBasicInfoService problemBasicInfoService;
    private final ServletRequest httpServletRequest;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/lock")
    public String lock() {
        return "lock";
    }

    @GetMapping("/problem")
    public ProblemDto problem(@Param("problemId") long problemId) {
        return ProblemDto.from(problemBasicInfoService.findById(problemId));
    }

    @GetMapping("/problemAndChoice")
    public ProblemDto problemAndChoice(@Param("problemId") long problemId) {
        return ProblemDto.from(problemBasicInfoService.findById(problemId));
    }


    @GetMapping("/solve")
    public CommonResult solve(@Param("problemSolve")ProblemSolveDto problemSolveDto) {
        String uid = httpServletRequest.getParameter("uid");
        return problemBasicInfoService.problemSolve(problemSolveDto.problemId, problemSolveDto.choices, uid);
    }
}
