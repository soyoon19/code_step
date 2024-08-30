package com.example.code_step.step.application.repository;

import com.example.code_step.step.infrastructure.CompensationJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompensationRepository {
    CompensationJpaEntity save(CompensationJpaEntity compensation);
    CompensationJpaEntity findById(long id);
    List<CompensationJpaEntity> findAll();
    void deleteById(long id);
}
