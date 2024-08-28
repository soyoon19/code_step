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

    private Integer orderNumber;

    private String title;

    @Builder
    public UnitJpaEntity(String languageId, Integer orderNumber, String title) {
        this.languageId = languageId;
        this.orderNumber = orderNumber;
        this.title = title;
    }


    public static UnitJpaEntity from(Unit model){
        UnitJpaEntity entity = UnitJpaEntity.builder()
                .languageId(model.getLanguageId())
                .title(model.getTitle())
                .orderNumber(model.getOrder())
                .build();

        entity.id = model.getId();
        return entity;
    }

    public Unit toModel(){
        return Unit.builder()
                .id(id)
                .languageId(languageId)
                .order(orderNumber)
                .title(title)
                .build();
    }

}
