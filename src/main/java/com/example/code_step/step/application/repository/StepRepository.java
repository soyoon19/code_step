package com.example.code_step.step.application.repository;

import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import com.example.code_step.step.infrastructure.StepJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StepRepository {
    StepJpaEntity findByUnitIdAndOrder(Long unitId, Integer order);
    boolean save(StepJpaEntity stepJpaEntity);
    StepJpaEntity findById(Long id);
    List<StepJpaEntity> findByUnitId(Long unitId);
}
