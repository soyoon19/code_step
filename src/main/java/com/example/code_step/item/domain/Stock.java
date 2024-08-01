package com.example.code_step.item.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Stock {
    @Setter
    private int count;

    private Item item;


}
