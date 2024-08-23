package com.example.code_step.rank.infrastructure;

import com.example.code_step.rank.application.repository.RankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RankRepositoryImpl implements RankRepository {
    private final RankJpaRepository rankJpaRepository;

    @Override
    public RankJpaEntity findById(Integer id) {
        return rankJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(RankJpaEntity rank) {
        return rankJpaRepository.save(rank) != null;
    }
}
