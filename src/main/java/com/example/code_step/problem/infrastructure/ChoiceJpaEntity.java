package com.example.code_step.problem.infrastructure;

import com.example.code_step.problem.domain.Choice;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "choice")
@NoArgsConstructor
public class ChoiceJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long problemId;

    private String description;

    private Boolean answer;

    private Integer orderNumber;

    @Builder
    public ChoiceJpaEntity(Long id, Long problemId, String description, Boolean answer, Integer orderNumber) {
        this.id = id;
        this.problemId = problemId;
        this.description = description;
        this.answer = answer;
        this.orderNumber = orderNumber;
    }

    public Choice toModel(){
        return Choice.builder()
                .answer(answer)
                .description(description)
                .id(id)
                .orderNumber(orderNumber)
                .problemId(problemId)
                .build();
    }

    public static ChoiceJpaEntity from(Choice choice){
        return ChoiceJpaEntity.builder()
                .answer(choice.answer())
                .id(choice.id())
                .description(choice.description())
                .orderNumber(choice.orderNumber())
                .problemId(choice.problemId())
                .build();
    }

}
