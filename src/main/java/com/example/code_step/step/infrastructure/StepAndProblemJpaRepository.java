package com.example.code_step.step.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepAndProblemJpaRepository extends JpaRepository<StepAndProblemJpaEntity, Long>{
    //Todo. 여기서부터 다시 시작

    List<StepAndProblemJpaEntity> findByProblemId(Long problemId);
    List<StepAndProblemJpaEntity> findByStepId(Long stepId);
}