package edu.matc.entity;

import java.util.ArrayList;

public class Members {

    private ArrayList<Member> memberList = new ArrayList<Member>();

    public void addMemberToList(Member member) {
        memberList.add(member);
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> members) {
        this.memberList = members;
    }

}
