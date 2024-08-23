package com.example.code_step.step.application.repository;

import com.example.code_step.step.infrastructure.StepAndProblemJpaEntity;

import java.util.List;

public interface StepAndProblemRepository {
    StepAndProblemJpaEntity findById(Long id);
    boolean save(StepAndProblemJpaEntity stepAndProblem);
    List<StepAndProblemJpaEntity> findByStepId(Long stepId);
    List<StepAndProblemJpaEntity> findByProblemId(Long problemId);

}
