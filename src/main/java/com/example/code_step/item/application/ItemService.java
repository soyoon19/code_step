package com.example.code_step.item.application;

import com.example.code_step.item.domain.Item;
import com.example.code_step.item.domain.repository.ItemRepository;
import com.example.code_step.item.infrastructure.ItemJpaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> findAll(){
        List<Item> items = new ArrayList<>();
        List<ItemJpaEntity> itemJpaEntities = itemRepository.findAll();
        for (ItemJpaEntity itemJpaEntity : itemJpaEntities)
            items.add(itemJpaEntity.toModel());

        return items;
    }
}
