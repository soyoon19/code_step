package com.example.code_step.step.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
public record Compensation(long id, int exp, int coin) implements Comparable<Compensation> {
    public Compensation plus(Compensation target) {
        return Compensation.builder()
                .exp(exp + target.exp())
                .coin(coin + target.coin())
                .build();
    }

    public Compensation minus(Compensation target) {
        return Compensation.builder()
                .coin(coin - target.coin())
                .build();
    }

    @Override
    public int compareTo(Compensation compensation) {
        if (coin > compensation.coin)
            return 1;
        else if (coin < compensation.coin)
            return -1;
        return 0;
    }
}
