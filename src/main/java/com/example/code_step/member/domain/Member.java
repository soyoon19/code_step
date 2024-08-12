package com.example.code_step.member.domain;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.step.domain.Compensation;
import lombok.Getter;

@Getter
public class Member {
    private float buffFactor = 1f;
    private int heart;

    private int age;
    private int study_count;
    private String username;
    private String uid;
    private String gender;

    private Inventory inventory;
    private Compensation compensation;


    public void decreaseHeart(){ heart--; }
    public void increaseHeart(int up){  heart += up; }

    public boolean isDie(){
        return heart < 1;
    }

    public void makeFriend(String uid){}

    public void addCompensation(Compensation compensation){
        this.compensation = this.compensation.plus(compensation);
    }

    public void minusCompensation(Compensation compensation){
        this.compensation = this.compensation.plus(compensation);
    }

    public void setBuffFactor(float buffFactor) {
        this.buffFactor = buffFactor;
    }

    public boolean availabilityBuy(Compensation price){
        return compensation.compareTo(price) >= 0;
    }
}
