package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LearningUnitJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long unitId;

    private Long learningLanguageId;

    private Float progress;

    public LearningUnit toModel(){
        return LearningUnit.builder()
                .id(id)
                .unitId(unitId)
                .learningLanguageId(learningLanguageId)
                .progress(progress).build();
    }
}
