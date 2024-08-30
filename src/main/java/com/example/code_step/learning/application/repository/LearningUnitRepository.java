package com.example.code_step.learning.application.repository;

import com.example.code_step.learning.infrastructure.LearningUnitJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LearningUnitRepository{
    List<LearningUnitJpaEntity> findByLearningLanguageId(Long learningLanguageId);
    LearningUnitJpaEntity findById(Long id);
    LearningUnitJpaEntity save(LearningUnitJpaEntity learningUnit);
    List<LearningUnitJpaEntity> saveAll(List<LearningUnitJpaEntity> learningUnits);

}