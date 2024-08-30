package com.example.code_step.step.application;

import com.example.code_step.step.application.repository.StepRepository;
import com.example.code_step.step.domain.Compensation;
import com.example.code_step.step.domain.Step;
import com.example.code_step.step.infrastructure.StepJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StepService {
    private final StepRepository stepRepository;
    private final CompensationService compensationService;

    //Todo : Compensation 파트가 안성되고 나머지 작업 수행

    public List<Step> findByUnitId(long unitId) {
        List<StepJpaEntity> entities = stepRepository.findByUnitId(unitId);
        List<Step> steps = new ArrayList<>();
        for (StepJpaEntity entity : entities) {
            steps.add(entity.toModel(compensationService.findById(entity.getCompensationId())));
        }

        return steps;
    }

    public boolean addStep(Step step) {
        return stepRepository.save(StepJpaEntity.form(step));
    }

    public Long nextStep(Long stepId){
        Step nowStep = null; // stepRepository.findById(stepId).toModel();
        Step nextStep = null; // nextStepJpaEntity = stepRepository.findByUnitIdAndOrder(nowStep.getUnitId(), nowStep.getOrder() + 1).toModel();
        return nextStep != null ? nextStep.getId() : null; // nextStepJpaEntity.toModel();
    }

}
