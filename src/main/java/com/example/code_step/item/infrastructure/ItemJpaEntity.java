package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Item;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemJpaEntity {
    @Id
    @Column(length = 150)
    private String id;

    public Item toModel(){
        return null;
    }
}
