package com.example.code_step.problem.domain;

import com.fasterxml.jackson.core.JsonToken;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


//문제 유형을 저장하게할지 고민된다.
@Builder

public record ProblemBasicInfo (Long id, String title, String description, int type){
    public static final int MULTIPLE_CHOICE_PROBLEM = 1;
    public static final int ORDER_PROBLEM = 2;
}
