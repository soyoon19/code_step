package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.StepAndProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepAndProblemJpaRepository extends JpaRepository<StepAndProblemJpaEntity, Long>{
    //Todo. 여기서부터 다시 시작
}