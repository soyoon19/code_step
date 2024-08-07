package com.example.code_step.step.domain;

import java.util.List;

public class Language implements Staged<Unit>{
    List<Unit> units;


    public List<Unit> selectUnit(){
        return units;
    }

    @Override
    public List<Unit> showStage() {
        return units;
    }
}
