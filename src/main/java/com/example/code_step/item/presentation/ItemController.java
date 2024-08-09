package com.example.code_step.item.presentation;

import com.example.code_step.item.application.ItemService;
import com.example.code_step.item.domain.Item;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/")
    public List<Item> findAll(){
        return itemService.findAll();
    }
}
