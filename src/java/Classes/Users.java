/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author user
 */
/**
 * Represents a user
 */
public class Users {
	
	private String username,name,surname,department;
        public static Integer usersCounter=0;
    
    /**
     * Creates a user with the specified username, name, surname and department
     * @param username
     * @param name
     * @param surname
     * @param department
     * 
     * Creates a counter for users
     * @param usersCounter
     */
    
    //constructor
    public  Users(String username, String name, String surname, String department){
    	this.username = username;
    	this.name = name;
    	this.surname = surname;
    	this.department = department;
    	this.usersCounter++;
    	
    }
    public Users(){
    	this.username = "";
    	this.name = "";
    	this.surname = "";
    	this.department = "";
    	this.usersCounter++;
    }
    
    //seters
    /**
     * Sets the user's username.
     * @param username A String containing the user's
     * username.
     */  
    public void setUsername(String username){
    	this.username = username;
    }
     
    /**
     * Sets the user's name.
     * @param name A String containing the user's
     * name.
     */
    public void setName(String name){
    	this.name = name;
    }
    
    /**
     * Sets the user's surname.
     * @param surname A String containing the user's
     * surname.
     */
    public void setSurname(String surname){
    	this.surname = surname;
    }
    
    /**
     * Sets the user's department.
     * @param department A String containing the user's
     * department.
     */
    public void setDepartment(String department){
    	this.department = department;
    }
    
    //getters
    /**
     * Gets the user's username.
     * @return A string representing the user's username.
     */
    public String getUsername(){
    	return this.username;
    }
    
    /**
     * Gets the user's name.
     * @return A string representing the user's name.
     */
    public String getName(){
    	return this.name;
    }
    
    /**
     * Gets the user's surname.
     * @return A string representing the user's surname.
     */
    public String getSurname(){
    	return this.surname;
    }
    
    /**
     * Gets the user's department.
     * @return A string representing the user's department.
     */
    public String getDepartment(){
    	return this.department;
    }
    

}

