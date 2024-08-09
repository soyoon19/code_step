package com.example.code_step.step.infrastructure;

import com.example.code_step.step.application.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LanguageRepositoryImpl implements LanguageRepository {
    private final LanguageJpaRepository languageJpaRepository;

    @Override
    public List<LanguageJpaEntity> findAll() {
        return languageJpaRepository.findAll();
    }
}
