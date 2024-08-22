package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class StockRepositoryImpl implements StockRepository {
    private final StockJpaRepository stockJpaRepository;

    @Override
    public StockJpaEntity findById(long id) {
        return stockJpaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(StockJpaEntity stock) {
        return stockJpaRepository.save(stock) != null;
    }

    @Override
    public void deleteById(long id) {
        stockJpaRepository.deleteById(id);
    }

    @Override
    public List<StockJpaEntity> findByInventoryId(long id) {
        return stockJpaRepository.findByInventoryId(id);
    }
}
