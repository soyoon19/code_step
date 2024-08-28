package com.example.code_step.problem.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceJpaRepository extends JpaRepository<ChoiceJpaEntity, Long> {
    List<ChoiceJpaEntity> findByProblemId(Long problemId);
}
