/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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

public class ProfessorsServl extends HttpServlet {

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
            out.println("<title>Servlet SecretariesServl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SecretariesServl at " + request.getContextPath() + "</h1>");
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
         
            Connection conn=null;
            String REGNUMBER =request.getParameter("REGNUMBER");
    	    String COURSEID = request.getParameter("COURSEID");
            
    	    String GRADE = request.getParameter("GRADE");
            int a = Integer.parseInt(GRADE);
            
            boolean flag=false;
        try {
          
             conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             
             String id = (String)request.getSession(false).getAttribute("id");
             
             System.out.println(id);
             
             String insertQuery = "INSERT INTO GRADES (REGNUMBER,COURSEID,PROFID,GRADE)"+ "VALUES('"+ REGNUMBER+"','"+ COURSEID+"','"+ id +"',"+ a+")";
             System.out.println(insertQuery);
             stmt.executeUpdate(insertQuery);
             
             
            
     
                       try (PrintWriter out = response.getWriter()) {
                       flag= true;    
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title></title>");            
                       out.println("</head>");
                       out.println("<body>");
                       out.println(" Succsesfull inset! <a href=\"page5.jsp\">Go back</a>" );
                       out.println("</body>");
                       out.println("</html>");
                      }
                       
               
             
           
            stmt.close();      
            conn.close();
            
            if(flag==false){
                try (PrintWriter out = response.getWriter()) {
                     out.println("<!DOCTYPE html>");
                      out.println("<html>");
                      out.println("<head>");
                      out.println("<title></title>");            
                      out.println("</head>");
                      out.println("<body>");
                      out.println("Unsuccessful login! <a href=\"Page2.jsp\">Go back</a>" );
                      out.println("</body>");
                      out.println("</html>");
             }
        }
         
        
               
               
               } catch (SQLException  ex) {
            Logger.getLogger(SecretariesServl.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch ( ClassNotFoundException ex) {
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
            
        try (PrintWriter out= response.getWriter()){
             
             conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             
             ResultSet rs=null;
            String id = (String)request.getSession(false).getAttribute("id");
             
             String SQL ="SELECT COURSES.COURSEID,STUDENTS.USERNAME,GRADES.GRADE FROM COURSES INNER JOIN PROFESSORS ON PROFESSORS.PROFID=COURSES.PROFID INNER JOIN GRADES ON GRADES.COURSEID=COURSES.COURSEID INNER JOIN STUDENTS ON STUDENTS.REGNUMBER=GRADES.REGNUMBER WHERE PROFESSORS.PROFID='"+ id + "'";
             System.err.println(SQL);
             rs = stmt.executeQuery(SQL);
             ArrayList forprint = new ArrayList();;
             int i=0;
            
             
             while(rs.next()){
                 forprint.add(rs.getString("COURSEID"));
                 forprint.add(rs.getString("USERNAME"));
                 forprint.add(rs.getString("GRADE"));
                 
                 i=i+3;
             }
             int k =1 ;
     
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title></title>");            
                       out.println("</head>");
                       out.println("<body>");
                       for ( int j=0;j<=i;j=j+3){
                       out.println("<h3>"+"COURSEID: "+forprint.get(j)+"USERNAME: "+forprint.get(j+1)+ "GRADE: " + forprint.get(j+2) +  "  </h3>" );
                       k++;
                       if (k%3==0){
                           out.println("<br>");
                       }
                       }
                       out.println("</body>");
                       out.println("</html>");
                     
          
               } catch (SQLException  ex) {
            Logger.getLogger(SecretariesServl.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch ( ClassNotFoundException ex) {
            Logger.getLogger(SecretariesServl.class.getName()).log(Level.SEVERE, null, ex);
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
