package com.example.granie2.albatross;

public class Contacts {
    public void setName(String n){
        this.name = n;
    }
    public void setPhone_num(int num){
        this.phone_num = num;
    }

    public void setClearance(int c) {
        this.clearance = c;
    }

    public int getnum(){
        int n = this.phone_num;
        return n;
    }
    private String name;
    private int phone_num;
    private int clearance;
}
