package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningStep;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "learning_step")
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

    public static LearningStepJpaEntity from(LearningStep learningStep){
        LearningStepJpaEntity entity =  LearningStepJpaEntity.builder()
                .state(learningStep.getState())
                .learningUnitId(learningStep.getLearningUnitId())
                .stepId(learningStep.getStepId())
                .build();

        entity.id = learningStep.getId();
        return entity;
    }

    @Builder
    public LearningStepJpaEntity(int state, long learningUnitId, long stepId){
        this.state = state;
        this.learningUnitId = learningUnitId;
        this.stepId = stepId;
    }
}
