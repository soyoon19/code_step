package com.example.code_step.learning.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.learning.domain.LearningStep;
import com.example.code_step.learning.domain.LearningUnit;
import com.example.code_step.learning.presentation.dto.LearningLanguageDto;
import com.example.code_step.learning.presentation.dto.LearningUnitDto;
import com.example.code_step.member.application.MemberService;
import com.example.code_step.member.domain.Member;
import com.example.code_step.step.application.LanguageService;
import com.example.code_step.step.application.UnitService;
import com.example.code_step.step.domain.Language;
import com.example.code_step.step.domain.Unit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LearningService {
    private final LanguageService languageService;
    private final UnitService unitService;
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

    //현재 학습하고 있는 기술 목록을 가져온다.
    public List<LearningLanguageDto> getLearningLanguageByUid(String uid){
        List<LearningLanguage> learningLanguages = learningLanguageService.findByUid(uid);
        List<LearningLanguageDto> learningLanguageDtos = new ArrayList<>();

        Language language;

        for(LearningLanguage learningLanguage : learningLanguages){
            language = languageService.findById(learningLanguage.getLanguageId());
            learningLanguageDtos.add(LearningLanguageDto.from(learningLanguage, language));
        }

        System.out.println("learningLanguageDtos size : " + learningLanguageDtos.size());

        return learningLanguageDtos;
    }

    public List<LearningUnitDto> getLearningUnitByLearningLanguageId(Long learningLanguageId){
        List<LearningUnit> learningUnits = learningUnitService.findByLearningLanguageId(learningLanguageId);
        List<LearningUnitDto> learningUnitDtos = new ArrayList<>();

        Unit unit;
        for (LearningUnit learningUnit : learningUnits) {
            unit = unitService.findById(learningUnit.getUnitId());
            learningUnitDtos.add(LearningUnitDto.from(learningUnit, unit));
        }

        return learningUnitDtos;
    }

    public List<LearningStep> getLearningStepByLearningUnitId(Long learningUnitId){
        return learningStepService.findByLearningUnitId(learningUnitId);
    }
}
