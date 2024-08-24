package com.example.code_step.learning.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.learning.domain.LearningStep;
import com.example.code_step.learning.domain.LearningUnit;
import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.domain.Member;
import com.example.code_step.step.application.LanguageService;
import com.example.code_step.step.domain.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LearningService {
    private final LanguageService languageService;
    private LearningLanguageService learningLanguageService;
    private LearningStepService learningStepService;
    private LearningUnitService learningUnitService;
    private MemberService memberService;

    public CommonResult addLearning(String uid, String learningId){
        Member member = memberService.findByUid(uid);
        Language language = languageService.findById(learningId);

        LearningLanguage learningLanguage = learningLanguageService.initLearningLanguage(member, language);
        if(learningLanguage == null)
            return CommonResult.builder()
                    .code(500)
                    .message("learned language")
                    .success(false)
                    .build();

        List<LearningUnit> learningUnits = learningUnitService.initLearningUnit(learningLanguage);
        for(LearningUnit learningUnit : learningUnits)
            learningStepService.initLearningStep(learningUnit);

        return CommonResult.builder()
                .code(200)
                .message("add language learning!")
                .success(true)
                .build();
    }
}
