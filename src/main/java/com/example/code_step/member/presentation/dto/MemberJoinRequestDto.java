package com.example.code_step.member.presentation.dto;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.member.domain.Member;
import com.example.code_step.rank.domain.Rank;
import com.example.code_step.step.domain.Compensation;

public class MemberJoinRequestDto {
    public int age;
    public String uid;
    public String gender;
    public String username;

    public Member toModel(Inventory inventory, Compensation compensation, Rank rank){
        return Member.builder()
                .age(age)
                .uid(uid)
                .gender(gender)
                .username(username)
                .heart(5)
                .studyCount(0)
                .rank(rank)
                .inventory(inventory)
                .compensation(compensation)
                .build();
    }
}
