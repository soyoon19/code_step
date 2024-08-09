package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Unit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UnitRepositoryImpl {
    private final UnitJpaRepository unitJpaRepository;
    public List<UnitJpaEntity> findByLanguageId(String languageId) {
        return unitJpaRepository.findByLanguageId(languageId);
    }
}
