package com.example.code_step.learning.domain;

import com.example.code_step.step.domain.Step;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LearningStep {
    public static final int NO_CLEAR = 0;
    public static final int CLEAR = 1;
    public static final int LEARNING = 2;

    private int state;
    private long stepId;
    private long id;
    private long learningUnitId;
}
