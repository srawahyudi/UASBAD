/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad;
import bad.database.ConnectionHelper;
import bad.database.VendorDataSource;
import java.sql.SQLException;
/**
 *
 * @author srawahyudi
 */
public class BAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        testConnection();
    } 
 
    private static void testConnection() {
        try {
            ConnectionHelper.getConnection();
            System.out.println("Database connected");
        } catch (SQLException ex) {
            System.out.println("Failed to connect database");
        }
    }
    
}
