package com.example.code_step.member.infrastructure;

import com.example.code_step.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberJpaEntity {
    @Id
    private String uid;

    public Member toModel() {
        //Todo 추후 구현 필요
        return null;
    }
}
