package com.example.code_step.learning.application;

import com.example.code_step.learning.application.repository.LearningUnitRepository;
import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.learning.domain.LearningUnit;
import com.example.code_step.learning.infrastructure.LearningUnitJpaEntity;
import com.example.code_step.step.application.UnitService;
import com.example.code_step.step.domain.Unit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LearningUnitService {
    private final LearningUnitRepository learningUnitRepository;
    private final UnitService unitService;

    public LearningUnit findById(Long id) {
        return learningUnitRepository.findById(id).toModel();
    }

    //Language 맞는 Unit를 바탕으로 LearningUnit를 생성한다.
    //초기화 및 객체 반환
    public List<LearningUnit> initLearningUnit(LearningLanguage learningLanguage) {
        List<Unit> units = unitService.findByLanguageId(learningLanguage.getLanguageId());
        List<LearningUnit> learningUnits = new ArrayList<>();

        LearningUnit learningUnit;
        for (Unit unit : units) {
            learningUnit = LearningUnit.builder()
                            .learningLanguageId(learningLanguage.getId())
                            .unitId(unit.getId())
                            .progress(0f).build();
            save(learningUnit);
            learningUnits.add(learningUnit);
        }

        return learningUnits;
    }

    public boolean save(LearningUnit learningUnit) {
        return learningUnitRepository.save(LearningUnitJpaEntity.from(learningUnit));
    }

    public List<LearningUnit> findByLearningLanguageId(Long learningLanguageId) {
        List<LearningUnitJpaEntity> learningUnits = learningUnitRepository.findByLearningLanguageId(learningLanguageId);
        return learningUnits.stream().map(LearningUnitJpaEntity::toModel).toList(); //신기하군
    }

}
