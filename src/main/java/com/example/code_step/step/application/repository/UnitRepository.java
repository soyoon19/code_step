package com.example.code_step.step.application.repository;

import com.example.code_step.step.infrastructure.UnitJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UnitRepository {
    boolean save(UnitJpaEntity unitJpaEntity);
    UnitJpaEntity findById(Long id);
    List<UnitJpaEntity> findByLanguageId(String languageId);
}
