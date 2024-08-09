package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Item;
import com.example.code_step.item.domain.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ItemRepositoryImpl implements ItemRepository {
    ItemJpaRepository itemJpaRepository;

    @Override
    public List<ItemJpaEntity> findAll() {
        return itemJpaRepository.findAll();
    }
}
