/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Courses;
import Classes.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author user
 */
public class AddCourseServl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewCoursesServl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewCoursesServl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Connection con=null;
        String Course_ID =request.getParameter("Course_id");
    	String Course_Name = request.getParameter("Course_name");
        String Prof_ID =request.getParameter("Prof_id");
    	String Semester = request.getParameter("Semester");
        int a=Integer.parseInt(Semester);
        
        Courses c = new Courses(Course_ID,Course_Name,Prof_ID,Semester);
        
        try {
          
            con = DBConnection.getConnection();
            
            Statement stmt = con.createStatement();
            
            String insertQuery = "INSERT INTO COURSES (COURSEID, COURSENAME,PROFID,SEMESTER)" + "VALUES ('" + c.getCourseID() + "','" + c.getCourseName() + "','" 
            + c.getProf() + "','" + a + "')"; 
            System.out.println(insertQuery);         
            stmt.executeUpdate(insertQuery);
            
             try (PrintWriter out = response.getWriter()) {
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title></title>");            
                       out.println("</head>");
                       out.println("<body>");
                       out.println("The course has been added!  <a href=\"Page3.jsp\">Go Back</a> " );
                       out.println("</body>");
                       out.println("</html>");
                      }
           
           stmt.close();    
           con.close(); 
        
        } catch (SQLException ex) {
            Logger.getLogger(SecretariesServl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SecretariesServl.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
         
         
        
    

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Connection conn=null;
        try (PrintWriter out = response.getWriter()) {
            conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             
             ResultSet rs=null;
             String SQL = "SELECT COURSES.COURSEID,COURSES.COURSENAME,COURSES.PROFID,COURSES.SEMESTER,USERS.SURNAME" + " "  + "FROM COURSES"
                     + " " +"INNER JOIN PROFESSORS ON COURSES.PROFID=PROFESSORS.PROFID"+ " " + "INNER JOIN USERS ON PROFESSORS.USERNAME=USERS.USERNAME";
             System.err.println(SQL);
             rs = stmt.executeQuery(SQL);
             ArrayList forprint = new ArrayList();;
             int i=0;
            while(rs.next()){
            forprint.add(rs.getString("COURSEID"));
            forprint.add(rs.getString("COURSENAME"));
            forprint.add(rs.getString("SURNAME"));
            forprint.add(rs.getString("PROFID"));
            forprint.add(rs.getString("SEMESTER"));
            i=i+5;    
            }
            int k = 1;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title></title>");
                out.println("</head>");
                out.println("<body>");
                for(int j=0;j<=i;j=j+5){
                out.println("<h3>"+ "COURSE "+ k +": COURSEID: " + forprint.get(j)+ " COURSENAME: " + forprint.get(j+1) + " SURNAME: " + forprint.get(j+2)
                        + " PROFID: " + forprint.get(j+3)+ " SEMESTER: " + forprint.get(j+4)+ "</h3>");
                k++;
                if(k%5==0){
                  out.println("<br>");
                }
                }
                out.println("<a href=\"Page3.jsp\">Go Back</a> " );
                out.println("</body>");
                out.println("</html>");
                      } catch (SQLException ex) {
            Logger.getLogger(AddCourseServl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCourseServl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
