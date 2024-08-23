package com.example.code_step.learning.infrastructure;

import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.step.domain.Language;
import com.example.code_step.step.infrastructure.LanguageJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LearningLanguageJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languageId;

    private String uid;


    @Builder
    public LearningLanguageJpaEntity(Long id, String languageId, String uid) {
        this.id = id;
        this.languageId = languageId;
        this.uid = uid;
    }

    public LearningLanguage toModel() {
        return LearningLanguage.builder()
                .uid(uid)
                .languageId(languageId)
                .id(id)
                .build();
    }

    public static LearningLanguageJpaEntity from(LearningLanguage language) {
        return LearningLanguageJpaEntity.builder()
                .languageId(language.getLanguageId())
                .id(language.getId())
                .uid(language.getUid())
                .build();
    }
}
