/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class DBConnection {
    private static final String url = "jdbc:derby://localhost";
    private static final String databaseName = "DBunipi";
    private static final int port = 1527;
    private static final String username = null;
    private static final String password = null;
        
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        
    return DriverManager.getConnection(url + ":" + port + "/" + databaseName ,username,password);
    }    
}