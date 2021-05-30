/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bad.database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author srawahyudi
 */
public class ProductDataSource {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String productId;
    public String productName;
    public String stock;
    
    public void simpanData() throws SQLException{
        conn = ConnectionHelper.getConnection();
        sql = "INSERT INTO Product(Product_ID, Product_Name, Stock)VALUE(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, productId);
        pst.setString(2, productName);
        pst.setString(3, stock); 
        pst.execute();
        pst.close();
    }
    
    public ResultSet UpdateProductTable() throws SQLException{
        conn = ConnectionHelper.getConnection();
        sql = "SELECT * FROM Product";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
