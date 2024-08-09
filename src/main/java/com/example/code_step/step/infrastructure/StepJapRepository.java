package com.example.code_step.step.infrastructure;

import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import com.example.code_step.step.domain.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepJapRepository extends JpaRepository<StepJpaEntity, Long> {
    StepJpaEntity findByUnitIdAndOrder(Long unitId, Integer order);
    List<StepJpaEntity> findByUnitId(Long unitId);
}
