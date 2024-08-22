package com.example.code_step.step.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompensationJpaRepository extends JpaRepository<CompensationJpaEntity, Long> {

}
