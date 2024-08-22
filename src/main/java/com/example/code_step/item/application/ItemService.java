package com.example.code_step.item.application;

import com.example.code_step.core.CommonResult;
import com.example.code_step.item.domain.Inventory;
import com.example.code_step.item.domain.Item;
import com.example.code_step.item.domain.repository.ItemRepository;
import com.example.code_step.item.infrastructure.ItemJpaEntity;
import com.example.code_step.member.application.repository.MemberRepository;
import com.example.code_step.member.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public List<Item> findAll(){
        List<Item> items = new ArrayList<>();
        List<ItemJpaEntity> itemJpaEntities = itemRepository.findAll();
        for (ItemJpaEntity itemJpaEntity : itemJpaEntities)
            items.add(itemJpaEntity.toModel());

        return items;
    }

    public CommonResult useItem(String itemId, String uid){
        Item item = itemRepository.findById(itemId).toModel();
        Member member = null; // Todo. MemberService 완성 후 다시 작성
        Inventory inventory = member.getInventory();

        inventory.useItem(item, member);

        return null;
    }
}
