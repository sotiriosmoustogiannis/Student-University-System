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
 * Represents a professor
 *
 */
public class Professors extends Users{
	
    String courseID;
    /**
     * Creates a professor with the specified username, name, surname, department
	 * that it inherits from Users class and specified courseID.
     * @param username
     * @param name
     * @param surname
     * @param department
     * @param courseID A String that represents the ID of a lesson which the teacher teaches.
     */
    
    //constructors
	public Professors(String username, String name, String surname, String department,String courseID){
            
		super(username,name,surname,department);
		this.courseID=courseID;
		
	}
	
	public Professors(String username, String name, String surname, String department){
		super(username,name,surname,department);
		
		this.courseID="";
	}
	
	public Professors(){
		super();
		this.courseID="";
	}

	/**
	 * Gets the professor's courseID.
	 * @return A String representing the professor's courseID.
	 */
	public String getCourseID(){
		return this.courseID;
	}
	
	//incomplete sub-question 9.3.1
	public void setGrade(){
	   System.out.println("O kathigitis ethese mia vathmologia sto X mathima");
	}
	
	//incomplete sub-question 9.3.2
	public Float getGrade(){
	   return null;
	}
	   
}

