package com.example.code_step.problem.infrastructure;

import com.example.code_step.problem.domain.Problem;
import com.example.code_step.problem.domain.ProblemBasicInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "problem")
@NoArgsConstructor
public class ProblemJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Integer type;

    @Builder
    public ProblemJpaEntity(Long id, String title, String description, Integer type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public ProblemBasicInfo toModel(){
        return ProblemBasicInfo.builder()
                .id(id)
                .title(title)
                .description(description)
                .type(type)
                .build();
    }

    public static ProblemJpaEntity from(ProblemBasicInfo problem){
        return ProblemJpaEntity.builder()
                .title(problem.title())
                .description(problem.description())
                .id(problem.id())
                .type(problem.type())
                .build();
    }

}
