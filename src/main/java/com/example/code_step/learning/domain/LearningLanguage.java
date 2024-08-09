package com.example.code_step.learning.domain;

import com.example.code_step.step.domain.Language;
import lombok.Builder;

@Builder
public class LearningLanguage {
    private long id;
    private String languageId;
    private String uid;
}
