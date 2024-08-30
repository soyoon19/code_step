package com.example.code_step.step.application;

import com.example.code_step.step.application.repository.LanguageRepository;
import com.example.code_step.step.domain.Language;
import com.example.code_step.step.infrastructure.LanguageJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public List<Language> findAll() {
        List<Language> languages = new ArrayList<>();
        List<LanguageJpaEntity> entities = languageRepository.findAll();
        for (LanguageJpaEntity entity : entities)
            languages.add(entity.toModel());

        System.out.println("languages : size " + languages.size());

        return languages;
    }

    public Language findById(String id) {
        return languageRepository.findById(id).toModel();
    }



    public boolean save(Language language) {
        return languageRepository.save(LanguageJpaEntity.from(language));
    }
}
