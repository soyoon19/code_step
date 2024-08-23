package com.example.code_step.step.application;

import com.example.code_step.step.application.repository.CompensationRepository;
import com.example.code_step.step.domain.Compensation;
import com.example.code_step.step.infrastructure.CompensationJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompensationService {
    private CompensationRepository compensationRepository;

    public Compensation findById(Long id) {
        return compensationRepository.findById(id).toModel();
    }

    public boolean save(Compensation compensation) {
        return compensationRepository.save(CompensationJpaEntity.from(compensation));
    }
}
