package com.example.code_step.learning.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.learning.application.repository.LearningLanguageRepository;
import com.example.code_step.learning.application.repository.LearningStepRepository;
import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.learning.infrastructure.LearningLanguageJpaEntity;


import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.domain.Member;
import com.example.code_step.step.application.LanguageService;
import com.example.code_step.step.domain.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LearningLanguageService {
    private final LearningLanguageRepository learningLanguageRepository;
    //private final MemberService memberService; //추후 Entity를 uid에서 Member member로 변경할 경우 사용할 수도 있음
    private final LanguageService languageService;

    //사용자가 새로운 language를 공부하기로 했을 경우
    public LearningLanguage initLearningLanguage(Member member, Language language) {
        List<LearningLanguage> learningLanguages = findByUid(member.getUid());

        for(LearningLanguage learningLanguage : learningLanguages)
            if(learningLanguage.getLanguageId().equals(language.getId())) //이미 배우고 있는 언어를 선택한 경우
                return null;

        LearningLanguage learningLanguage = LearningLanguage.builder()
                .languageId(language.getId())
                .uid(member.getUid())
                .build();

        save(learningLanguage);
        return learningLanguage;
    }

    //uid로 현재 공부하고 있는 언어들의 공부상태를 가져온다.
    public List<LearningLanguage> findByUid(String uid) {
        List<LearningLanguageJpaEntity> entities = learningLanguageRepository.findByUid(uid);
        List<LearningLanguage> learningLanguages = new ArrayList<>();
        for (LearningLanguageJpaEntity entity : entities)
            learningLanguages.add(entity.toModel());

        return learningLanguages;
    }

    public boolean save (LearningLanguage learningLanguage) {
        return learningLanguageRepository.save(LearningLanguageJpaEntity.from(learningLanguage));
    }
}
