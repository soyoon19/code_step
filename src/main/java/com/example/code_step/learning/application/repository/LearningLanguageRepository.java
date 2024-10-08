package com.example.code_step.learning.application.repository;

import com.example.code_step.learning.domain.LearningStep;
import com.example.code_step.learning.infrastructure.LearningLanguageJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LearningLanguageRepository {
    List<LearningLanguageJpaEntity> findByUid(String uid);
    boolean save(LearningLanguageJpaEntity learningLanguage);
    LearningLanguageJpaEntity findById(Long id);
}
