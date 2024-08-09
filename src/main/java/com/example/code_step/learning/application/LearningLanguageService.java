package com.example.code_step.learning.application;

import com.example.code_step.learning.application.repository.LearningLanguageRepository;
import com.example.code_step.learning.application.repository.LearningStepRepository;
import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.learning.infrastructure.LearningLanguageJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LearningLanguageService {
    private final LearningLanguageRepository learningLanguageRepository;

    //uid로 검색
    public List<LearningLanguage> findByUid(String uid) {
        List<LearningLanguageJpaEntity> entities = learningLanguageRepository.findByUid(uid);
        List<LearningLanguage> learningLanguages = new ArrayList<>();
        for (LearningLanguageJpaEntity entity : entities)
            learningLanguages.add(entity.toModel());

        return learningLanguages;
    }


}
