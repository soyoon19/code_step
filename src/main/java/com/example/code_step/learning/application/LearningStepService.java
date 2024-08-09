package com.example.code_step.learning.application;

import com.example.code_step.learning.domain.LearningStep;
import com.example.code_step.learning.application.repository.LearningStepRepository;
import com.example.code_step.learning.infrastructure.LearningStepJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LearningStepService {
    private final LearningStepRepository learningStepRepository;

    //Step state 클리어로 변경
    public void clearStep(long stepId){
        setStepState(stepId, LearningStep.CLEAR);
    }

    //Step state 시작중으로 변경
    public void learningStep(long stepId){
        setStepState(stepId, LearningStep.LEARNING);
    }

    private void setStepState(long stepId, int state){
        LearningStepJpaEntity stepJpaEntity = learningStepRepository.findById(stepId);
        LearningStep step = stepJpaEntity.toModel();

        step.setState(state);

        learningStepRepository.save(LearningStepJpaEntity.from(step));
    }

    //현재 사용자 Unit에 맞는 Step 정보를 가져온다.
    public List<LearningStep> findByLearningUnitId(Long learningUnitId) {
        List<LearningStepJpaEntity> entities = learningStepRepository.findByLearningUnitId(learningUnitId);
        List<LearningStep> learningSteps = new ArrayList<>();
        for (LearningStepJpaEntity entity : entities)
            learningSteps.add(entity.toModel());

        return learningSteps;
    }
}
