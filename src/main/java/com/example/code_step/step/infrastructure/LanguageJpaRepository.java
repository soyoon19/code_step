package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageJpaRepository extends JpaRepository<LanguageJpaEntity, String> {

}
