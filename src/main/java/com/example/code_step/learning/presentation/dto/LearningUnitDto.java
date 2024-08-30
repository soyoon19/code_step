package com.example.code_step.learning.presentation.dto;

import com.example.code_step.learning.domain.LearningUnit;
import com.example.code_step.step.domain.Unit;
import lombok.Builder;

@Builder
public class LearningUnitDto {
    public int progress;
    public String title;
    public int order;
    public Long learningUnitId;

    public static LearningUnitDto from(LearningUnit learningUnit, Unit unit) {
        return LearningUnitDto.builder()
                .learningUnitId(learningUnit.getId())
                .order(unit.getOrder())
                .progress((int) (learningUnit.getProgress() * 100))
                .title(unit.getTitle())
                .build();
    }
}
