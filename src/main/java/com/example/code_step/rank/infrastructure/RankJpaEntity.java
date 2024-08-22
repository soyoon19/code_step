package com.example.code_step.rank.infrastructure;

import com.example.code_step.rank.domain.Rank;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class RankJpaEntity {
    @Id
    Integer id;

    String name;
    private Integer nextRankId;
    private Integer nextExp;
    private Integer nowExp;
    private String imgPath;

    @Builder
    public RankJpaEntity(Integer id, String name, Integer nextRankId, Integer nextExp, Integer nowExp, String imgPath) {
        this.id = id;
        this.name = name;
        this.nextRankId = nextRankId;
        this.nextExp = nextExp;
        this.nowExp = nowExp;
        this.imgPath = imgPath;
    }

    public Rank toModel(){
        return Rank.builder()
                .id(id)
                .name(name)
                .nextRankId(nextRankId)
                .nextExp(nextExp)
                .nowExp(nowExp)
                .imgPath(imgPath)
                .build();
    }

    public static RankJpaEntity from(Rank rank){
        return RankJpaEntity.builder()
                .nextRankId(rank.getNextRankId())
                .nextExp(rank.getNextExp())
                .nowExp(rank.getNowExp())
                .imgPath(rank.getImgPath())
                .name(rank.getName())
                .id(rank.getId())
                .build();
    }

}
