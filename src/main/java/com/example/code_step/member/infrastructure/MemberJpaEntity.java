package com.example.code_step.member.infrastructure;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.member.domain.Member;
import com.example.code_step.rank.domain.Rank;
import com.example.code_step.step.domain.Compensation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MemberJpaEntity {
    @Id
    private String uid;

    private String username;
    private String gender;
    private Integer age;
    private Integer studyCount;

    private Float buffFactor;
    private Integer heart;

    private Long inventoryId;
    private Long compensationId;
    private Integer rankId;



    @Builder
    public MemberJpaEntity(String uid, String username, String gender, Integer age, Integer studyCount, Float buffFactor, Integer heart, Long inventoryId, Long compensationId, Integer rankId) {
        this.uid = uid;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.studyCount = studyCount;
        this.buffFactor = buffFactor;
        this.heart = heart;
        this.inventoryId = inventoryId;
        this.compensationId = compensationId;
        this.rankId = rankId;
    }


    public Member toModel(Inventory inventory, Compensation compensation, Rank rank) {
        //Todo 추후 구현 필요
        return Member.builder()
                .compensation(compensation)
                .inventory(inventory)
                .heart(heart)
                .age(age)
                .studyCount(studyCount)
                .buffFactor(buffFactor)
                .uid(uid)
                .gender(gender)
                .rank(rank)
                .username(username)
                .build();
    }

    public MemberJpaEntity from(Member member){
        return MemberJpaEntity.builder()
                .uid(member.getUid())
                .username(member.getUsername())
                .gender(member.getGender())
                .age(member.getAge())
                .studyCount(member.getStudyCount())
                .buffFactor(member.getBuffFactor())
                .heart(member.getHeart())
                .inventoryId(member.getInventory().getId())
                .compensationId(member.getCompensation().id())
                .rankId(member.getRank().getId())
                .build();
    }
}
