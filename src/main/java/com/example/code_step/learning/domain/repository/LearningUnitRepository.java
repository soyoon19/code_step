package com.example.code_step.learning.domain.repository;

import com.example.code_step.learning.infrastructure.LearningUnitJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LearningUnitRepository{
    List<LearningUnitJpaEntity> findByLearningLanguageId(Long learningLanguageId);
}