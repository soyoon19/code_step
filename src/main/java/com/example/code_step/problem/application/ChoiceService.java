package com.example.code_step.problem.application;

import com.example.code_step.problem.application.repository.ChoiceRepository;
import com.example.code_step.problem.domain.Choice;
import com.example.code_step.problem.infrastructure.ChoiceJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChoiceService {
    private ChoiceRepository choiceRepository;

    public Choice findChoice(Long id) {
        return choiceRepository.findById(id).toModel();
    }

    public List<Choice> findByProblemId(Long problemId) {
        return choiceRepository.findByProblemId(problemId).stream().map(ChoiceJpaEntity::toModel).toList();
    }

    public boolean save(Choice choice) {
        return choiceRepository.save(ChoiceJpaEntity.from(choice));
    }

}
