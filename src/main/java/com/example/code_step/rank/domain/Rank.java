package com.example.code_step.rank.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rank {
    public static final int START_RANK_ID = 1;

    private int id;
    private String name;
    //객체로 가져오면 모든 객체를 호출하는 형태가 되기 때문에 ID로 저장 및 아이디롤 통해서 가져오도록 했다.
    private int nextRankId;
    private int nextExp;
    private int nowExp;
    private String imgPath;

    public boolean checkNext(int exp){
        return nextExp > exp;
    }
}
