package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Compensation;
import com.example.code_step.step.domain.Step;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "step")
public class StepJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer orderNumber; //order은 예약어

    private Long unitId;

    private Long compensationId;

    @Builder
    public StepJpaEntity(Integer orderNumber, Long unitId, Long compensationId) {
        this.orderNumber = orderNumber;
        this.unitId = unitId;
        this.compensationId = compensationId;
    }

    public Step toModel(Compensation compensation) {
        return Step.builder()
                .unitId(unitId)
                .order(orderNumber)
                .id(id)
                .compensation(compensation)
                .build();
    }

    public static StepJpaEntity form(Step step) {
        StepJpaEntity entity = StepJpaEntity.builder()
                .unitId(step.getUnitId())
                .compensationId(step.getCompensation().id())
                .orderNumber(step.getOrder())
                .build();

        if(step.getId() != 0) entity.id = step.getId();
        return entity;
    }
}
