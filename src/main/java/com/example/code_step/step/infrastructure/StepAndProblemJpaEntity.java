package com.example.code_step.step.infrastructure;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "step_and_problem")
public class StepAndProblemJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long problemId;

    private Long stepId;

    private Integer orderNumber;

    @Builder
    public StepAndProblemJpaEntity(Long id, Long problemId, Long stepId, Integer orderNumber) {
        this.problemId = problemId;
        this.stepId = stepId;
        this.orderNumber = orderNumber;
    }
}
