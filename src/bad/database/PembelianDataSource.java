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
import javax.swing.JOptionPane;

/**
 *
 * @author srawahyudi
 */
public class PembelianDataSource {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String purchaseID;
    public String purchaseDate;
    public String vendorId;
    public String vendorRefNo;
    public String productID;
    public String quantity;
    public String price;
    
    public void simpanData() throws SQLException{
        conn = ConnectionHelper.getConnection();
        sql = "INSERT INTO Purchase(Purchase_ID, Purchase_Date, Vendor_ID, Vendor_RefNo)VALUE(?,?,?,?)";
        sql = "INSERT INTO Purchase_Detail(Purchase_ID, Product_ID, Quantity, Price)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, purchaseID);
        pst.setString(2, purchaseDate);
        pst.setString(3, vendorId); 
        pst.setString(4, vendorRefNo); 
        pst.setString(5, productID); 
        pst.setString(6, quantity); 
        pst.setString(7, price); 
        pst.execute();
        pst.close();
    }
    
    
}
