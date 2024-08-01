package com.example.code_step.member.domain;

import com.example.code_step.item.domain.Inventory;
import com.example.code_step.problem.domain.Compensation;
import lombok.Getter;

@Getter
public class Member {
    private float buffFactor = 1f;
    private Compensation compensation;
    private Inventory inventory;
    private int heart;


    public void decreaseHeart(){ heart--; }
    public void increaseHeart(int up){  heart += up; }

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
