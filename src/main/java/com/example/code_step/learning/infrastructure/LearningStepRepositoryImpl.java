package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.application.repository.LearningStepRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LearningStepRepositoryImpl implements LearningStepRepository {
    private LearningStepJpaRepository learningStepJpaRepository;

    @Override
    public List<LearningStepJpaEntity> findByLearningUnitId(Long learningUnitId) {
        return learningStepJpaRepository.findByLearningUnitId(learningUnitId);
    }

    @Override
    public LearningStepJpaEntity findById(Long id) {
        return learningStepJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(LearningStepJpaEntity learningStepJpaEntity) {
        return learningStepJpaRepository.save(learningStepJpaEntity) != null;
    }
}
