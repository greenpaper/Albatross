package com.example.albatross;

import java.util.HashMap;
import java.util.Map;


public class User {
    private Map<String, Contacts> contact_list = new HashMap<>();
    public void setName(String n){
        this.name = n;
    }
    public void setEmail(String e){
        this.email = e;
    }
    public void setUsername(String un){
        this.username = un;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
    public void setPhone(int num){
        this.phone = num;
    }

    public String getName(){
        String n = this.name;
        return n;
    }
    public String getEmail(){
        String e = this.email;
        return e;
    }
    public int getphone(){
        int num = this.phone;
        return num;
    }
    public String getUname(){
        String un = this.username;
        return un;
    }
    public String getPassword(){
        String un = this.password;
        return un;
    }
    public void add_contact(String name, int num, int clearance){
        Contacts contact = new Contacts();
        contact.setName(name);
        contact.setPhone_num(num);
        contact.setClearance(clearance);
        this.contact_list.put(name, contact);
    }
    public int get_contact(String name){
        return this.contact_list.get(name).getnum();
    }
    public void remove_contact(String name){
        this.contact_list.remove(name);
    }
//    public String get_username(String e){
//        if(e.contentEquals(email)){
//            String un = username;
//            return un;
//        }
//
//    }

    private String name;
    private String email;
    private String username;
    private String password;
    private int phone;
}
