package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemJpaRepository extends JpaRepository<ItemJpaEntity, Integer> {

}
