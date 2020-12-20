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
 * Represents a student
 */
public class Students extends Users{
	private final int registrationNumber;
	/**
	 * Creates a student with the specified username, name, surname, department
	 * that it inherits from Users class and specified registration number
	 * @param username
	 * @param name
	 * @param surname
	 * @param department
	 * @param registrationNumber An int that represents the registration number of a student
	 */
	
	 public Students(String username, String name, String surname, String department,int registrationNumber){
		 super(username,name,surname,department);
		 	
	    	this.registrationNumber = registrationNumber;
	    	
	 }
	public Students(){
		super();
		this.registrationNumber=0;
	}
	 
	/**
	 * Gets the student's registraton number.
	 * @return A int representing the student's registraton number.
	 */
	 public int getRegistrationNumber(){
		 return this.registrationNumber;
	 }
	 
	//sub-question 9.2.1 not completed
	 public void CoursesGrade(){
		 System.out.println("gia to mathima X h vathmologia sou einai Y");
	 }
	 
}

