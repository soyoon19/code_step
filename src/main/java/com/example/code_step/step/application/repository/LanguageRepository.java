package com.example.code_step.step.application.repository;

import com.example.code_step.step.infrastructure.LanguageJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LanguageRepository {
    List<LanguageJpaEntity> findAll();
}
