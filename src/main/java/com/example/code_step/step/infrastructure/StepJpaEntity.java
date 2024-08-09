package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Compensation;
import com.example.code_step.step.domain.Step;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class StepJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int order;

    private Long unitId;

    private Long compensationId;

    @Builder
    public StepJpaEntity(int order, Long unitId, Long compensationId) {
        this.order = order;
        this.unitId = unitId;
        this.compensationId = compensationId;
    }

    public Step toModel(Compensation compensation) {
        return Step.builder()
                .unitId(unitId)
                .order(order)
                .id(id)
                .compensation(compensation)
                .build();
    }

    public static StepJpaEntity form(Step step) {
        StepJpaEntity entity = StepJpaEntity.builder()
                .unitId(step.getUnitId())
                .compensationId(step.getCompensation().id())
                .order(step.getOrder())
                .build();

        if(step.getId() != 0) entity.id = step.getId();
        return entity;
    }
}
