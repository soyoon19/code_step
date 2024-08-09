package com.example.code_step.step.application;

import com.example.code_step.step.application.repository.UnitRepository;
import com.example.code_step.step.domain.Unit;
import com.example.code_step.step.infrastructure.UnitJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;

    public List<Unit> findByLanguageId(String languageId) {
        List<UnitJpaEntity> entities =  unitRepository.findByLanguageId(languageId);
        List<Unit> units = new ArrayList<>();
        for (UnitJpaEntity entity : entities)
            units.add(entity.toModel());

        return units;
    }

    public boolean addUnit(Unit unit) {
        return unitRepository.save(UnitJpaEntity.form(unit));
    }
}
