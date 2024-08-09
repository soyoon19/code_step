package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LanguageJpaEntity {
    @Id
    private String id;

    private String name;

    private String imagePath;

    @Builder
    public LanguageJpaEntity(String id, String name, String imagePath) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
    }

    public Language toModel() {
        return Language.builder()
                .id(id)
                .name(name)
                .imgPath(imagePath)
                .build();
    }

    public static LanguageJpaEntity from(Language language) {
        return LanguageJpaEntity.builder()
                .id(language.getId())
                .name(language.getName())
                .imagePath(language.getImgPath())
                .build();
    }


}
