package com.example.code_step.learning.infrastructure;


import com.example.code_step.learning.application.repository.LearningLanguageRepository;
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


}
