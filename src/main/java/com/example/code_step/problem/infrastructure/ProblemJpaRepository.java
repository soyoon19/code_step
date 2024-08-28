package com.example.code_step.problem.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemJpaRepository extends JpaRepository<ProblemJpaEntity, Long> {

}
