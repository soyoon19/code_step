package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LanguageJpaEntity {
    @Id
    private String id;

    private String name;

    private String imagePath;

    public Language toModel() {
        return Language.builder()
                .id(id)
                .name(name)
                .imgPath(imagePath)
                .build();
    }
}
