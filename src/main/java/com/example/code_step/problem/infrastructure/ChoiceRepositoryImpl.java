package com.example.code_step.problem.infrastructure;

import com.example.code_step.problem.application.repository.ChoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ChoiceRepositoryImpl implements ChoiceRepository {
    private ChoiceJpaRepository choiceJpaRepository;

    @Override
    public ChoiceJpaEntity findById(long id) {
        return choiceJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(ChoiceJpaEntity choice) {
        return choiceJpaRepository.save(choice) != null;
    }

    @Override
    public List<ChoiceJpaEntity> findByProblemId(long problemId) {
        return choiceJpaRepository.findByProblemId(problemId);
    }
}
