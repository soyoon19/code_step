package com.example.code_step.member.domain;

import com.example.code_step.problem.domain.Compensation;

public class Member {
    private float buffFactor = 1f;
    private Compensation compensation;

    public int decreaseHeart(){ return  0; }
    public int increaseHeart(int up){ return  1; }

    public void selectLanguage(String language) {}
    public void selectCourse(String course) {}

    public void makeFriend(String uid){}

    public void useItem(){}
    public void buyItem(){}

    public void solveProblem(){}

    public void addCompensation(Compensation compensation){
        this.compensation = this.compensation.plus(compensation);
    }

    public void setBuffFactor(float buffFactor) {
        this.buffFactor = buffFactor;
    }
}
