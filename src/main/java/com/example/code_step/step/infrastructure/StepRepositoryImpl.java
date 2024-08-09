package com.example.code_step.step.infrastructure;

import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import com.example.code_step.step.application.repository.LanguageRepository;
import com.example.code_step.step.application.repository.StepRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StepRepositoryImpl implements StepRepository {
    private final StepJapRepository stepJapRepository;

    @Override
    public StepJpaEntity findByUnitIdAndOrder(Long unitId, Integer order) {
        return stepJapRepository.findByUnitIdAndOrder(unitId, order);
    }

    @Override
    public boolean save(StepJpaEntity stepJpaEntity) {
        return stepJapRepository.save(stepJpaEntity) != null;
    }

    @Override
    public StepJpaEntity findById(Long id) {
        return stepJapRepository.findById(id).orElse(null);
    }

    @Override
    public List<StepJpaEntity> findByUnitId(Long unitId) {
        return stepJapRepository.findByUnitId(unitId);
    }
}
