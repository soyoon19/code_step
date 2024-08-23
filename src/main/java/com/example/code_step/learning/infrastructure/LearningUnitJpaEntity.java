package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LearningUnitJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long unitId;

    private Long learningLanguageId;

    private Float progress;

    @Builder
    public LearningUnitJpaEntity(Long id, Long unitId, Long learningLanguageId, Float progress) {
        this.id = id;
        this.unitId = unitId;
        this.learningLanguageId = learningLanguageId;
        this.progress = progress;
    }

    public LearningUnit toModel(){
        return LearningUnit.builder()
                .id(id)
                .unitId(unitId)
                .learningLanguageId(learningLanguageId)
                .progress(progress).build();
    }

    public static LearningUnitJpaEntity from(LearningUnit learningUnit){
        return LearningUnitJpaEntity.builder()
                .id(learningUnit.getId())
                .unitId(learningUnit.getUnitId())
                .learningLanguageId(learningUnit.getLearningLanguageId())
                .progress(learningUnit.getProgress())
                .build();
    }
}
