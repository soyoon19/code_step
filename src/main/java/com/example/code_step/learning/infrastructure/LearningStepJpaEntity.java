package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningStep;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LearningStepJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int state;

    private long learningUnitId;

    private long stepId;

    public LearningStep toModel(){
        return LearningStep.builder()
                .state(state)
                .stepId(stepId)
                .learningUnitId(learningUnitId)
                .id(id)
                .build();
    }
}
