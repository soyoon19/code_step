package com.example.code_step.member.application.repository;

import com.example.code_step.member.infrastructure.MemberJpaEntity;
import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {
    MemberJpaEntity findByUid(String uid);
    boolean save(MemberJpaEntity member);
    void delete(MemberJpaEntity member);
    boolean exists(String uid);
}
