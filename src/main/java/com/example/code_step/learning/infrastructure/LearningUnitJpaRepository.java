package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningUnitJpaRepository extends JpaRepository<LearningUnitJpaEntity, Long> {
    List<LearningUnitJpaEntity> findByLearningLanguageId(Long learningLanguageId);
}
