package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningStepJpaRepository extends JpaRepository<LearningStepJpaEntity, Long> {
    List<LearningStepJpaEntity> findByLearningUnitId(Long learningUnitId);
}
