package com.example.code_step.item.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockJpaRepository extends JpaRepository<StockJpaEntity, Long> {
    List<StockJpaEntity> findByInventoryId(Long inventoryId);
}
