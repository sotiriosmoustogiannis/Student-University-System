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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author user
 */

public class SecretariesServl extends HttpServlet {

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
            String username =request.getParameter("username");
    	    String password = request.getParameter("password");
           HttpSession ses = request.getSession(true);
           ses.setAttribute("username", username);
               
        try {
          
             conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs=null;
             ResultSet rs1=null;
             ResultSet rs2=null;
             
             

             String SQL = "SELECT * FROM USERS INNER JOIN STUDENTS ON USERS.USERNAME=STUDENTS.USERNAME WHERE USERS.USERNAME='" + username + "'"
                        + " AND USERS.PASSWORD = '" + password + "' AND STUDENTS.REGNUMBER LIKE 'p%'";                 
             rs = stmt.executeQuery(SQL);   
             while(rs.next()){
                      System.out.println(rs.getString("USERNAME"));
                       try (PrintWriter out = response.getWriter()) {
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title></title>");            
                       out.println("</head>");
                       out.println("<body>");
                       out.println("Successful login! Continue here  <a href=\"page4.jsp\">Start</a> " );
                       out.println("</body>");
                       out.println("</html>");
                      }
         
             }
     
              String SQL1 = "SELECT * FROM USERS INNER JOIN PROFESSORS ON USERS.USERNAME=PROFESSORS.USERNAME WHERE USERS.USERNAME='" + username + "'"
                        + " AND USERS.PASSWORD = '" + password + "' AND PROFESSORS.PROFID LIKE 'k%'";           
                
                ResultSet rs3=null;
                String insertQuery2="SELECT PROFESSORS.PROFID FROM PROFESSORS INNER JOIN USERS ON USERS.USERNAME=PROFESSORS.USERNAME WHERE USERS.USERNAME='" + username + "'";
                rs3 = stmt.executeQuery(insertQuery2);
                while(rs3.next()){
                String id=rs3.getString("PROFID");
                 HttpSession ses2 = request.getSession(true);
                 ses.setAttribute("id", id );
                }
                rs1 = stmt.executeQuery(SQL1);
                while(rs1.next()){
                     
                      
                    
                      try (PrintWriter out = response.getWriter()) {                                             
                      out.println("<!DOCTYPE html>");
                      out.println("<html>");
                      out.println("<head>");
                      out.println("<title></title>");            
                      out.println("</head>");
                      out.println("<body>");
                      out.println("Successful login! Continue here  <a href=\"page5.jsp\">Start</a>  " );
                      out.println("</body>");
                      out.println("</html>");
                      }
                 
                }
                
                 
                String SQL2 = "SELECT * FROM USERS INNER JOIN SECRETARIES ON USERS.USERNAME=SECRETARIES.USERNAME WHERE USERS.USERNAME='" + username + "'"
                        + " AND USERS.PASSWORD = '" + password + "' AND SECRETARIES.SECID LIKE 's%'";           
                rs2 = stmt.executeQuery(SQL2);  
                
                while(rs2.next()){
                    
                      
                    
                      try (PrintWriter out = response.getWriter()) {                                             
                      out.println("<!DOCTYPE html>");
                      out.println("<html>");
                      out.println("<head>");
                      out.println("<title></title>");            
                      out.println("</head>");
                      out.println("<body>");
                      out.println("Successful login! Continue here  <a href=\"Page3.jsp\">Start</a> " );
                      out.println("</body>");
                      out.println("</html>");
                      }
                   
                }
                    
           stmt.close();      
           conn.close();
           if(rs.equals(out)==false){
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
           
        } catch (SQLException | ClassNotFoundException ex) {
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
