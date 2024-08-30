package com.example.code_step.learning.presentation.dto;

import com.example.code_step.learning.domain.LearningLanguage;
import com.example.code_step.step.domain.Language;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LearningLanguageDto {
    public String languageId;
    public String languageName;
    public String imgPath;
    public Long learningLanguageId;

    public static LearningLanguageDto from(LearningLanguage learningLanguage, Language language) {
        return LearningLanguageDto.builder()
                .languageId(learningLanguage.getLanguageId())
                .languageName(language.getName())
                .imgPath(language.getImgPath())
                .learningLanguageId(learningLanguage.getId())
                .build();
    }
}
