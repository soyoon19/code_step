package com.example.code_step.learning.infrastructure;


import com.example.code_step.learning.application.repository.LearningLanguageRepository;
import com.example.code_step.learning.domain.LearningStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LearningLanguageRepositoryImpl implements LearningLanguageRepository {
    private LearningLanguageJpaRepository learningLanguageJpaRepository;

    @Override
    public List<LearningLanguageJpaEntity> findByUid(String uid) {
        return learningLanguageJpaRepository.getByUid(uid);
    }

    @Override
    public boolean save(LearningLanguageJpaEntity learningLanguage) {
        return learningLanguageJpaRepository.save(learningLanguage) != null;
    }

    @Override
    public LearningLanguageJpaEntity findById(Long id) {
        return learningLanguageJpaRepository.findById(id).orElse(null);
    }


}
