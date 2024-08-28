package com.example.code_step.step.presentation;

import com.example.code_step.step.application.LanguageService;
import com.example.code_step.step.domain.Language;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/languages/")
    public List<Language> getLanguages() {
        return languageService.findAll();
    }

    @GetMapping("/language/add")
    public Boolean addLanguage(String languageName, String languageId) {
        return null; //Todo. 문제 추가 기능 구현 후 구현
    }


}
