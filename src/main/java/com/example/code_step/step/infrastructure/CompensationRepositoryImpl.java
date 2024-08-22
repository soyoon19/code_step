package com.example.code_step.step.infrastructure;

import com.example.code_step.step.application.repository.CompensationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CompensationRepositoryImpl implements CompensationRepository {
    private final CompensationJpaRepository compensationJpaRepository;


    @Override
    public boolean save(CompensationJpaEntity compensation) {
        return compensationJpaRepository.save(compensation) != null;
    }

    @Override
    public CompensationJpaEntity findById(long id) {
        return compensationJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<CompensationJpaEntity> findAll() {
        return compensationJpaRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        compensationJpaRepository.deleteById(id);
    }
}
