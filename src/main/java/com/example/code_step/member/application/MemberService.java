package com.example.code_step.member.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.item.domain.Inventory;
import com.example.code_step.member.application.repository.MemberRepository;
import com.example.code_step.member.domain.Member;
import com.example.code_step.member.infrastructure.MemberJpaEntity;
import com.example.code_step.member.presentation.dto.MemberJoinRequestDto;
import com.example.code_step.rank.domain.Rank;
import com.example.code_step.rank.domain.repository.RankRepository;
import com.example.code_step.step.application.repository.CompensationRepository;
import com.example.code_step.step.domain.Compensation;
import com.example.code_step.step.infrastructure.CompensationJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final RankRepository rankRepository;
    private final CompensationRepository compensationRepository;

    public CommonResult join(MemberJoinRequestDto requestDto) {
        Compensation compensation = Compensation.builder().build();
        compensationRepository.save(CompensationJpaEntity.from(compensation));

//        Inventory inventory = new Inventory();
//
//
//
//
//        Member member = requestDto.toModel(new Inventory(),
//                Compensation.builder()
//                        .exp(0)
//                        .coin(0)
//                        .build(),
//                rankRepository.findById(Rank.START_RANK_ID).toModel());
//
//        memberRepository.save(MemberJpaEntity.)
        return null;
    }
}
