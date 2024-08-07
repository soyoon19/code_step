package com.example.code_step.step.domain;

import java.util.List;

public class Unit  implements Staged<Step>{
    List<Step> steps;

    public void selectStep() {
    }


    @Override
    public List<Step> showStage() {
        return steps;
    }
}
