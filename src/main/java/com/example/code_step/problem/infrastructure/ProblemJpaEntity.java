package com.example.code_step.problem.infrastructure;

import com.example.code_step.problem.domain.Problem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProblemJpaEntity {
    @Id
    private Long id;

    public Problem toModel(){
        return null;
    }

}
