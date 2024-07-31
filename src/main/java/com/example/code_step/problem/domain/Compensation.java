package com.example.code_step.problem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Compensation {
    private int exp;
    private int coin;

    public Compensation plus(Compensation target){
        return Compensation.builder()
                .exp(exp + target.getExp())
                .coin(coin + target.getCoin())
                .build();
    }
}
