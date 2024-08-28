package com.example.code_step.step.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Unit  implements Staged<Step>{
    private Long id;
    private String title;
    private int order;
    private String languageId;

}
