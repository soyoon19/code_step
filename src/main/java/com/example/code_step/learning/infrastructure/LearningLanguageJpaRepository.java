package com.example.code_step.learning.infrastructure;

import com.example.code_step.step.infrastructure.LanguageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningLanguageJpaRepository extends JpaRepository<LearningLanguageJpaEntity, Long> {
    List<LearningLanguageJpaEntity> getByUid(String uid);
}
