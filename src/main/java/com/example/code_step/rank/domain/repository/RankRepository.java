package com.example.code_step.rank.domain.repository;

import com.example.code_step.rank.infrastructure.RankJpaEntity;
import org.springframework.stereotype.Component;

@Component
public interface RankRepository {
    RankJpaEntity findById(Integer id);
    boolean save(RankJpaEntity rank);
}
