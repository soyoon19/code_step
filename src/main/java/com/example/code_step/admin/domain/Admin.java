package com.example.code_step.admin.domain;

import com.example.code_step.member.domain.Member;
import com.example.code_step.problem.domain.Problem;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    List<Member> member = new ArrayList<>();
    List<Problem> problem = new ArrayList<>();
    //admin
    public void joinAdmin(){}
    public void loginAdmin(){}
    //problem
    public void makeProblem(){}
    public void updateProblem(){}
    public void deleteProblem(){}
    public List<Problem> viewProblem(){return problem;}
    //course
    public void makeCourse(){}
    public void updateCourse(){}
    public void deleteCourser(){}
    //item
    public void makeItem(){}
    public void updateItem(){}
    public void deleteItem(){}
    //quest
    public void makeQuest(){}
    public void updateQuest(){}
    public void deleteQuest(){}
    //member
    public List<Member> viewMember(){return member;}
}