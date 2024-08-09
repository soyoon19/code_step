package com.example.code_step.learning.application.repository;

import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LearningStepRepository {
    List<LearningStepJpaEntity> findByLearningUnitId(Long learningUnitId);
    LearningStepJpaEntity findById(Long id);
    boolean save(LearningStepJpaEntity learningStepJpaEntity);
}
