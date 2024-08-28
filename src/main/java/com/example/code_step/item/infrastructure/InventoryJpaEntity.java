package com.example.code_step.item.infrastructure;

import com.example.code_step.item.domain.Inventory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//이 클래스는 필요 유무를 생각해 볼 필요가 있을것 같다.
//따로 엔티티로 관리할 필요 없이 Inventory에 식별자를 uid로 한 뒤에
//stock이 가르키는 Inventory를 uid로만 하면 되지 않을까?
//꼭 도메인 객체는 영속성 객체로 존재할 필요가 있나
@Entity
@NoArgsConstructor
@Getter
@Table(name = "inventory")
public class InventoryJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder
    public InventoryJpaEntity(Long id) {
        this.id = id;
    }

    public Inventory toModel(){
        return Inventory.builder()
                .id(id)
                .build();
    }

    public static InventoryJpaEntity from(Inventory inventory){
        return InventoryJpaEntity.builder()
                .id(inventory.getId())
                .build();
    }
}
