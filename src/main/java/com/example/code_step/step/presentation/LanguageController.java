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

    @GetMapping("/language/")
    public List<Language> getLanguages() {
        return languageService.findAll();
    }
}
