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
 * @author sotom
 */
public class StudentsServl extends HttpServlet {

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
            out.println("<title>Servlet StudentsServl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentsServl at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        Connection con=null;

        try (PrintWriter out = response.getWriter()){
            con = DBConnection.getConnection();
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs=null;
            String username = (String)request.getSession(false).getAttribute("username");

        
            String SQL = "SELECT GRADES.COURSEID, COURSES.COURSENAME, GRADES.GRADE\n" +
                         "FROM GRADES INNER JOIN COURSES ON GRADES.COURSEID=COURSES.COURSEID\n" +
                         "INNER JOIN STUDENTS ON GRADES.REGNUMBER=STUDENTS.REGNUMBER WHERE STUDENTS.USERNAME='" + username +"' ";       
            rs = stmt.executeQuery(SQL);   
                
                ArrayList forprint2 = new ArrayList();;
                int i=0;
                 while(rs.next()){
                  System.out.println("eftasa while");
                     System.out.println(rs.getString("COURSEID"));
                     System.out.println(rs.getString("COURSENAME"));
                     System.out.println(rs.getString("GRADE"));

                    forprint2.add(rs.getString("COURSEID"));
                    forprint2.add(rs.getString("COURSENAME"));
                    forprint2.add(rs.getString("GRADE"));
                    
                    
                    i=i+3;    
            }
            int k = 1;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title></title>");
                out.println("</head>");
                out.println("<body>");
                //out.println("<h3>  + username </h3>");
                for(int j=0;j<=i;j=j+3){
                out.println("<h3>"+ "COURSE "+ k +": COURSEID: " + forprint2.get(j)+ " COURSENAME: " + forprint2.get(j+1) + " GRADE: " + forprint2.get(j+2) + "</h3>");
                k++;
                if(k%3==0){
                  out.println("<br>");
                }
                }
                out.println("<a href=\"Page3.jsp\">Go Back</a> " );
                out.println("</body>");
                out.println("</html>");
             
             
            
                 
                 
               /*   if(rs.equals(out)==false){
                try (PrintWriter out = response.getWriter()) {
                     out.println("<!DOCTYPE html>");
                      out.println("<html>");
                      out.println("<head>");
                      out.println("<title></title>");            
                      out.println("</head>");
                      out.println("<body>");
                      out.println("Wrong registration! <a href=\"Page2.jsp\">Go back</a>" );
                      out.println("</body>");
                      out.println("</html>");
             }
        }
             */    
        }
        catch(SQLException ex) {
            Logger.getLogger(StudentsServl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsServl.class.getName()).log(Level.SEVERE, null, ex);
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
       // processRequest(request, response);
       Connection conn=null;
       
        try (PrintWriter out = response.getWriter()) {
            conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
             
            ResultSet rs1=null;
            String username = (String)request.getSession(false).getAttribute("username");
             //System.out.println(username + "skatoules");
                     
            String SQL = "SELECT AVG(GRADES.GRADE) as AVGSEM,SEMESTER\n" +
                         "FROM GRADES INNER JOIN COURSES ON GRADES.COURSEID=COURSES.COURSEID\n" +
                         "INNER JOIN STUDENTS ON GRADES.REGNUMBER=STUDENTS.REGNUMBER WHERE STUDENTS.USERNAME='" + username +"'\n "+
                         "GROUP BY SEMESTER";
                                        
             
             rs1 = stmt.executeQuery(SQL);
             ArrayList forprint = new ArrayList();;
             int i=0;
            while(rs1.next()){
            forprint.add(rs1.getString("AVGSEM"));
            forprint.add(rs1.getString("SEMESTER"));
           
            
            i=i+2;    
            }
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title></title>");
                out.println("</head>");
                out.println("<body>");
                for(int j=0;j<=i;j=j+2){
                out.println("<h3>"+" AVGSEM: " + forprint.get(j) + " SEMESTER: " + forprint.get(j+1) + "</h3>");
                
                }
                out.println(" <a href=\"Page2.jsp\">Go Back</a> " );
                out.println("</body>");
                out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(StudentsServl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentsServl.class.getName()).log(Level.SEVERE, null, ex);
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
