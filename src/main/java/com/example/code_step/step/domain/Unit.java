package com.example.code_step.step.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Unit  implements Staged<Step>{
    private Long id;
    private String title;
    private int order;
    private String languageId;

}
