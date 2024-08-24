package com.example.code_step.problem.presentation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProblemController {
    //private final ProblemService problemService;


    @GetMapping("/test")
    public String test() {
        return "test";
    }


    @GetMapping("/lock")
    public String lock() {
        return "lock";
    }
}
