package com.example.code_step.problem.presentation;

import com.example.code_step.problem.application.ProblemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ProblemController {
    private final ProblemService problemService;


}
