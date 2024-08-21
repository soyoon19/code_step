package com.example.code_step.step.infrastructure;

import com.example.code_step.step.application.repository.UnitRepository;
import com.example.code_step.step.domain.Unit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UnitRepositoryImpl implements UnitRepository {
    private final UnitJpaRepository unitJpaRepository;

    @Override
    public boolean save(UnitJpaEntity unitJpaEntity) {
        return unitJpaRepository.save(unitJpaEntity) != null;
    }

    @Override
    public UnitJpaEntity findById(Long id) {
        return unitJpaRepository.findById(id).orElse(null);
    }

    public List<UnitJpaEntity> findByLanguageId(String languageId) {
        return unitJpaRepository.findByLanguageId(languageId);
    }
}
