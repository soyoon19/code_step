package com.example.code_step.member.infrastructure;

import com.example.code_step.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MemberJpaEntity {
    @Id
    private String uid;

    private String username;

    private String gender;

    private Integer age;

    private Integer study_count;


    public Member toModel() {
        //Todo 추후 구현 필요
        return null;
    }
}
