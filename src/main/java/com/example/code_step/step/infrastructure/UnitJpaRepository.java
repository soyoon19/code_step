package com.example.code_step.step.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitJpaRepository extends JpaRepository<UnitJpaEntity, Long> {
    List<UnitJpaEntity> findByLanguageId(String languageId);
}
