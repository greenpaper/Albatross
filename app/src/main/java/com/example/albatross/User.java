package com.example.albatross;

import java.util.HashMap;
import java.util.Map;


/** <b>User</b> represents an <b>mutable</b> user.
 It includes all of the data associated with that user profile
 <p>
 Users represented with their data such as names etc.. as strings
 <p>
 class designed to manipulate user data easily
 used in conjunction with the DatabaseHelper class and register/login features
 */
public class User {
    private Map<String, Contacts> contact_list = new HashMap<>();
    /*	@param n as the name
	 *
    	@effects set name of user
    	@modifies name
    	@throws nothing
    	@return nothing
	 */
    public void setName(String n){
        this.name = n;
    }
    /*	@param e as email
	 *
    	@effects set email of user
    	@modifies email
    	@throws nothing
    	@return nothing
	 */
    public void setEmail(String e){
        this.email = e;
    }
    /*	@param un as username
	 *
    	@effects set username of user
    	@modifies username
    	@throws nothing
    	@return nothing
	 */
    public void setUsername(String un){
        this.username = un;
    }
    /*	@param pass as password
	 *
    	@effects set password of user
    	@modifies password
    	@throws nothing
    	@return nothing
	 */
    public void setPassword(String pass){
        this.password = pass;
    }
    /*	@param num as phone number
	 *
    	@effects set phone number of user
    	@modifies phone number
    	@throws nothing
    	@return nothing
	 */
    public void setPhone(int num){
        this.phone = num;
    }

    /*  @param none
    	@return variable name as a String
	 */
    public String getName(){
        String n = this.name;
        return n;
    }
    /*  @param none
    	@return variable email as a String
	 */
    public String getEmail(){
        String e = this.email;
        return e;
    }
    /*  @param none
    	@return variable phone as a integer
	 */
    public int getphone(){
        int num = this.phone;
        return num;
    }
    /*  @param none
    	@return variable username as a String
	 */
    public String getUname(){
        String un = this.username;
        return un;
    }
    /*  @param none
    	@return variable password as a String
	 */
    public String getPassword(){
        String un = this.password;
        return un;
    }
    /*	@param name, number and clearance of the user
	 *
    	@effects insert into users contact list
    	@modifies contact
    	@throws nothing
    	@return nothing
	 */
    public void add_contact(String name, int num, int clearance){
        Contacts contact = new Contacts();
        contact.setName(name);
        contact.setPhone_num(num);
        contact.setClearance(clearance);
        this.contact_list.put(name, contact);
    }
    /*	@param name of user in contacts
	 *
    	@effects none
    	@modifies nothing
    	@throws nothing
    	@return variable name as a String
	 */
    public int get_contact(String name){
        return this.contact_list.get(name).getnum();
    }
    /*	@param name of user in contacts
	 *
    	@effects remove user from contacts
    	@modifies contact_list
    	@throws nothing
    	@return nothing
	 */
    public void remove_contact(String name){
        this.contact_list.remove(name);
    }


    private String name;
    private String email;
    private String username;
    private String password;
    private int phone;
}
