package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.application.repository.LearningUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LearningUnitRepositoryImpl implements LearningUnitRepository {
    private final LearningUnitJpaRepository learningUnitJpaRepository;

    @Override
    public List<LearningUnitJpaEntity> findByLearningLanguageId(Long learningLanguageId) {
        return learningUnitJpaRepository.findByLearningLanguageId(learningLanguageId);
    }
}
