package com.example.code_step.learning.presentation;

import com.example.code_step.core.CommonResult;
import com.example.code_step.learning.application.LearningLanguageService;
import com.example.code_step.learning.application.LearningService;
import com.example.code_step.learning.domain.LearningStep;
import com.example.code_step.learning.domain.LearningUnit;
import com.example.code_step.learning.presentation.dto.LearningLanguageDto;
import com.example.code_step.learning.presentation.dto.LearningUnitDto;
import com.example.code_step.step.domain.Step;
import com.example.code_step.step.domain.Unit;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LearningLanguageController {
    private final LearningService learningService;
    private final LearningLanguageService learningLanguageService;

    @GetMapping("/learning")
    public List<LearningLanguageDto> getLearningLanguages(HttpServletRequest request) {
        return learningService.getLearningLanguageByUid((String) request.getAttribute("uid"));
    }

    @PostMapping("/learning")
    public CommonResult addLearningLanguage(@RequestParam("languageId") String languageId, HttpServletRequest request){
        return learningService.addLearning((String) request.getAttribute("uid"), languageId);
    }

    @GetMapping("/learning/unit")
    public List<LearningUnitDto> findLearningUnits(@RequestParam("learningLanguageId") Long learningLanguageId, HttpServletRequest request){
        return learningService.getLearningUnitByLearningLanguageId(learningLanguageId);
    }

    @GetMapping("/learning/step")
    public List<LearningStep> findLearningSteps(@RequestParam("learningUnitId") Long learningUnitId){
        return learningService.getLearningStepByLearningUnitId(learningUnitId);
    }

}
