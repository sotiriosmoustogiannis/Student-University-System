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
 * Represents the grades
 *
 */
public class Grades {
	
	private Courses course;
	private float grade;
	
	public Grades(){
		this.grade=0;
	}
	public Grades(float grade){
		this.grade = grade;
	}
	
	public float getGrade(){
		return grade;
	}
	
	
}
