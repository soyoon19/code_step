package com.example.code_step.problem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Compensation implements Comparable<Compensation> {
    private int exp;
    private int coin;

    public Compensation plus(Compensation target){
        return Compensation.builder()
                .exp(exp + target.getExp())
                .coin(coin + target.getCoin())
                .build();
    }

    public Compensation minus(Compensation target){
        return Compensation.builder()
                .coin(coin - target.getCoin())
                .build();
    }

    @Override
    public int compareTo(Compensation compensation) {
        if(coin > compensation.coin)
            return 1;
        else if(coin < compensation.coin)
            return -1;
        return 0;
    }
}
