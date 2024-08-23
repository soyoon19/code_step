package com.example.code_step.member.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.item.application.InventoryService;
import com.example.code_step.item.domain.Inventory;
import com.example.code_step.member.application.repository.MemberRepository;
import com.example.code_step.member.domain.Member;
import com.example.code_step.member.infrastructure.MemberJpaEntity;
import com.example.code_step.member.presentation.dto.MemberJoinRequestDto;
import com.example.code_step.rank.application.RankService;
import com.example.code_step.rank.domain.Rank;
import com.example.code_step.rank.application.repository.RankRepository;
import com.example.code_step.step.application.CompensationService;
import com.example.code_step.step.domain.Compensation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private final RankService rankService;
    private final InventoryService inventoryService;
    private final CompensationService compensationService;


    public CommonResult join(MemberJoinRequestDto requestDto) {
        if(memberRepository.exists(requestDto.uid)) //이미 회원이 존재하는 경우
            return CommonResult.builder()
                    .success(false)
                    .code(500)
                    .message("existed member!")
                    .build();

        //재화(보상)를 저장하는 객체 생성 및 저장
        Compensation compensation = Compensation.builder().build();
        compensationService.save(compensation);

        //Inventory 객체 생성 및 저장
        Inventory inventory = Inventory.builder().build();
        inventoryService.save(inventory);

        //START Rank 객체 가져오기
        Rank rank = rankService.findById(Rank.START_RANK_ID);


        //join 정보 + 기타 초기 정보로 Member 객체 생성 및 저장
        Member member = requestDto.toModel(
                inventory, compensation, rank
        );

        if(save(member)) //회원가입에 성공하는 경우
            return CommonResult.builder()
                    .success(true)
                    .code(200)
                    .message("Join Successful")
                    .build();
        else //회원 가입을 실패했다면
            return CommonResult.builder()
                    .success(false)
                    .code(500)
                    .message("Join Failed")
                    .build();

    }

    public boolean save(Member member){
        return memberRepository.save(MemberJpaEntity.from(member));
    }

}
