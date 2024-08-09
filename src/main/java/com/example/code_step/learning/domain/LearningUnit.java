package com.example.code_step.learning.domain;

import com.example.code_step.step.domain.Step;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LearningUnit {
    private Long learningLanguageId;
    private Long unitId;
    private Long id;

    private float progress;

    public float calculateProgress(List<LearningStep> stepList) {
        int cnt = 0;
        for (LearningStep step : stepList)
            if(step.getState() == LearningStep.CLEAR)
                cnt++;

        return progress = (float) cnt / (float) stepList.size() * 100;
    }
}