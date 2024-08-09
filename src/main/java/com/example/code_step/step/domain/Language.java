package com.example.code_step.step.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Language implements Staged<Unit>{
    protected String name;
    protected String id;
    protected String imgPath;


}
