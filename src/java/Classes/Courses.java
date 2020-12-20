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
public class Courses {
    
	private String courseName;
	private String courseID;
	private String Prof;
        private String semester;
	//private Vector<Students> studentsOfCourse = new Vector<Students>();
	/**
	 * Creates a course with the specified courseName, courseID and and the names of students who attend the course.
	 * @param courseName    Name of course
	 * @param courseID      Id of course
	 * @param studentsOfCourse A vector that contains the students who attend a course
	 */
	//,Vector<Students> studentsOfCourse
	public Courses(String courseID,String courseName,String Prof,String semester){
		this.courseName = courseName;
		this.courseID = courseID;
		//this.studentsOfCourse = studentsOfCourse;
		this.Prof=Prof;
                this.semester=semester;
	}
	
	public Courses(){
		this.courseName="";
		this.courseID="";
                this.Prof=null;
                this.semester="";
		//this.Prof=null;
	}
	
	/**
	 * Gets the course's courseName.
	 * @return A string representing the course's coursename.
	 */
	public String getCourseName(){
		return this.courseName;
	}
	
	/**
	 * 	 * Gets the students of a course that they attend .
	 * @return A vector that contains the students of a course
	 */
	//public Vector<Students> getStudentsOfCourse(){
	//	return studentsOfCourse;
	//}
	
	/**
	 * Gets the course's courseID.
	 * @return A string representing the course's courseID.
	 */
	public String getCourseID(){
		return this.courseID;
	}
	
	/**
	 * 
	 * @return Return the data of a professor
	 */
	//public Professors getProf(){
	//	return this.Prof;
	//}
	public String getProf(){
		return this.Prof;
	}
	public String getSemester(){
		return this.semester;
	}
	
	/**
	 * Sets the the professor of one course.
	 * @param Prof  An object professors containing the professor's
     * data.
	 */
	//public void  SetProf(Professors Prof){
	//	this.Prof=Prof;
	//}
	
	/**
	 * Sets the course's courseID.
	 * @param courseID A String containing the course's
     * id.
	 */
	public void  SetcourseID(String courseID){
		this.courseID=courseID;
	}
	
	/**
	 * Sets the course's courseName.
	 * @param courseName   A String containing the course's
     * name.
	 */
	public void  SetcourseName(String courseName){
		this.courseName=courseName;
	}
        public void setProf(){
		this.Prof=Prof;
	}
	public void setSemester(){
		this.semester=semester;
	}
}
