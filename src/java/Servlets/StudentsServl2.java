/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class StudentsServl2 extends HttpServlet {

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
            out.println("<title>Servlet StudentsServl2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentsServl2 at " + request.getContextPath() + "</h1>");
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



        
       
        try (PrintWriter out = response.getWriter()) {
            conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
             
            ResultSet rs1=null;
            String username = (String)request.getSession(false).getAttribute("username");
                     
            String SQL ="SELECT AVG(GRADES.GRADE) AS AVGGRADE\n" +
                        "FROM GRADES INNER JOIN STUDENTS ON GRADES.REGNUMBER=STUDENTS.REGNUMBER \n" +
                         "WHERE GRADES.GRADE IS NOT NULL AND STUDENTS.USERNAME='" + username +"' "; 
                                        
             rs1 = stmt.executeQuery(SQL);
             ArrayList forprint = new ArrayList();;
             int i=0;
            while(rs1.next()){
            forprint.add(rs1.getString("AVGGRADE"));
           
            i=i+1;    
            }
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title></title>");
                out.println("</head>");
                out.println("<body>");
                for(int j=0;j<=i;j=j+1){
                out.println("<h3>"+" AVGSEM: " + forprint.get(j) + "</h3>");
                
                }
                out.println(" <a href=\"Page2.jsp\">Go Back</a> " );
                out.println("</body>");
                out.println("</html>");
     
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
        processRequest(request, response);
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
