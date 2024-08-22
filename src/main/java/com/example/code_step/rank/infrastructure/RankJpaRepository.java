package com.example.code_step.rank.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankJpaRepository extends JpaRepository<RankJpaEntity, Integer> {
}
