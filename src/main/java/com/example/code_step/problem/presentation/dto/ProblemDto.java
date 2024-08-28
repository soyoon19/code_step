package com.example.code_step.problem.presentation.dto;

import com.example.code_step.problem.domain.Problem;
import com.example.code_step.problem.domain.ProblemBasicInfo;
import lombok.Builder;

@Builder
public class ProblemDto {
    public Long id;
    public String title;
    public String description;
    public int type;

    public static ProblemDto from(ProblemBasicInfo problem) {
        return ProblemDto.builder()
                .id(problem.id())
                .title(problem.title())
                .description(problem.description())
                .type(problem.type())
                .build();
    }
}
