package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Unit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class UnitJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languageId;

    private int order;

    private String title;

    @Builder
    public UnitJpaEntity(String languageId, int order, String title) {
        this.languageId = languageId;
        this.order = order;
        this.title = title;
    }


    public static UnitJpaEntity form(Unit model){
        UnitJpaEntity entity = UnitJpaEntity.builder()
                .languageId(model.getLanguageId())
                .title(model.getTitle())
                .order(model.getOrder())
                .build();

        entity.id = model.getId();
        return entity;
    }

    public Unit toModel(){
        return Unit.builder()
                .id(id)
                .languageId(languageId)
                .order(order)
                .title(title)
                .build();
    }

}
