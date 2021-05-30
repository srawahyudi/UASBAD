/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad.database;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author srawahyudi
 */
public class ConnectionHelper {
    private static final String DATABASE_NAME = "Purchasing";
    private static final String USER = "root";
    private static final String PASSWORD = "121212wahyu";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME;
 
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
    
}
