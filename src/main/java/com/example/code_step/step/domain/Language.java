package com.example.code_step.step.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Language implements Staged<Unit>{
    protected String name;
    protected String id;
    protected String imgPath;


}
