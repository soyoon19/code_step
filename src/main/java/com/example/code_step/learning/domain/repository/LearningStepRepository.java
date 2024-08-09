package com.example.code_step.learning.domain.repository;

import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LearningStepRepository {
    List<LearningStepJpaEntity> findByLearningUnitId(Long learningUnitId);
}
