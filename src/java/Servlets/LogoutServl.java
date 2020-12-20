package Servlets;

import Classes.Courses;
import Classes.DBConnection;

import static com.sun.corba.se.impl.util.RepositoryId.cache;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.file.Files.delete;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.catalina.startup.ExpandWar.delete;
import org.apache.catalina.webresources.Cache;
import static org.apache.derby.iapi.reference.Module.CacheFactory;

/**
 *
 * @author sotom
 */


public class LogoutServl extends HttpServlet {
    
  

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
            out.println("<title>Servlet LogoutServl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogoutServl at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
        
         Connection con=null;
      
        try {
          
            con = DBConnection.getConnection();
            
            Statement stmt = con.createStatement();
           
          
    
             try (PrintWriter out = response.getWriter()) {
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title></title>");            
                       out.println("</head>");
                       out.println("<body>");
                       out.println("LOGOUT  <a href=\"Page2.jsp\">Go Back</a> " );
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