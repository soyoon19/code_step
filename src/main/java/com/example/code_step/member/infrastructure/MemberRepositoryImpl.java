package com.example.code_step.member.infrastructure;

import com.example.code_step.member.application.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final MemberJpaRepository memberJpaRepository;


    @Override
    public MemberJpaEntity findByUid(String uid) {
        return memberJpaRepository.findById(uid).orElse(null);
    }

    @Override
    public boolean save(MemberJpaEntity member) {
        return memberJpaRepository.save(member) != null;
    }

    @Override
    public void delete(MemberJpaEntity member) {
        memberJpaRepository.delete(member);
    }
}
