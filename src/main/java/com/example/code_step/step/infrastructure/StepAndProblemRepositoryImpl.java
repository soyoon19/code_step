package com.example.code_step.step.infrastructure;

import com.example.code_step.step.application.repository.StepAndProblemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StepAndProblemRepositoryImpl implements StepAndProblemRepository {
    private final StepAndProblemJpaRepository stepAndProblemJpaRepository;

    @Override
    public StepAndProblemJpaEntity findById(Long id) {
        return stepAndProblemJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(StepAndProblemJpaEntity stepAndProblem) {
        return stepAndProblemJpaRepository.save(stepAndProblem) != null;
    }

    @Override
    public List<StepAndProblemJpaEntity> findByStepId(Long stepId) {
        return stepAndProblemJpaRepository.findByStepId(stepId);
    }

    @Override
    public List<StepAndProblemJpaEntity> findByProblemId(Long problemId) {
        return stepAndProblemJpaRepository.findByProblemId(problemId);
    }
}
