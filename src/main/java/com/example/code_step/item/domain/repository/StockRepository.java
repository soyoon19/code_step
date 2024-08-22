package com.example.code_step.item.domain.repository;

import com.example.code_step.item.infrastructure.StockJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockRepository{
    StockJpaEntity findById(long id);
    boolean save(StockJpaEntity stock);
    void deleteById(long id);
    List<StockJpaEntity> findByInventoryId(long id);
}
