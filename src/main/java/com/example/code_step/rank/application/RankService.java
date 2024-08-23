package com.example.code_step.rank.application;

import com.example.code_step.rank.application.repository.RankRepository;
import com.example.code_step.rank.domain.Rank;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RankService {
    private final RankRepository rankRepository;

    public Rank findById(int id) {
        return rankRepository.findById(id).toModel();
    }


}
