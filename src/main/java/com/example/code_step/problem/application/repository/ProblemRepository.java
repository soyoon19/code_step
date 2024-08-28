package com.example.code_step.problem.application.repository;

import com.example.code_step.problem.infrastructure.ProblemJpaEntity;
import org.springframework.stereotype.Component;

@Component
public interface ProblemRepository {
    ProblemJpaEntity findById(long id);
    boolean save(ProblemJpaEntity problem);

}
