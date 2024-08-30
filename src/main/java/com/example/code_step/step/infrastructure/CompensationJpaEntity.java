package com.example.code_step.step.infrastructure;

import com.example.code_step.step.domain.Compensation;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "compensation")

public class CompensationJpaEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int exp;

    private int coin;

    @Builder
    public CompensationJpaEntity(Long id, int exp, int coin) {
        this.id = id;
        this.exp = exp;
        this.coin = coin;
    }

    public Compensation toModel(){
        return Compensation.builder()
                .id(id)
                .coin(coin)
                .exp(exp)
                .build();
    }

    public static CompensationJpaEntity from(Compensation compensation){
        return CompensationJpaEntity.builder()
                .coin(compensation.coin())
                .id(compensation.id())
                .exp(compensation.exp())
                .build();
    }
}
