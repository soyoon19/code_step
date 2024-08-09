package com.example.code_step.item.domain.repository;

import com.example.code_step.item.domain.Item;
import com.example.code_step.item.infrastructure.ItemJpaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemRepository {
    List<ItemJpaEntity> findAll();
}
