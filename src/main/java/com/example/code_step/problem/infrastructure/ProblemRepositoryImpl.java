package com.example.code_step.problem.infrastructure;

import com.example.code_step.problem.application.repository.ProblemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProblemRepositoryImpl implements ProblemRepository {
    private ProblemJpaRepository problemJpaRepository;

    @Override
    public ProblemJpaEntity findById(long id) {
        return problemJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(ProblemJpaEntity problem) {
        return problemJpaRepository.save(problem) != null;
    }
}
