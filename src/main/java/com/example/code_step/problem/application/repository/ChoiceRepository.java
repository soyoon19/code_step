package com.example.code_step.problem.application.repository;

import com.example.code_step.problem.infrastructure.ChoiceJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChoiceRepository {
    ChoiceJpaEntity findById(long id);
    boolean save(ChoiceJpaEntity choice);
    List<ChoiceJpaEntity> findByProblemId(long problemId);
}
