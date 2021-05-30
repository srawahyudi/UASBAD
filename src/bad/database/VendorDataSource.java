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
public class VendorDataSource {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String vendorId;
    public String vendorName;
    public String vendorAdd;
    
    public void simpanData() throws SQLException{
        conn = ConnectionHelper.getConnection();
        sql = "INSERT INTO Vendor(Vendor_ID, Vendor_Name, Vendor_Add)VALUE(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, vendorId);
        pst.setString(2, vendorName);
        pst.setString(3, vendorAdd); 
        pst.execute();
        pst.close();
    }
    
    public ResultSet UpdateVendorTable() throws SQLException{
        conn = ConnectionHelper.getConnection();
        sql = "SELECT * FROM Vendor";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
    public ResultSet searchVendorName(String s){
        try{
            conn = ConnectionHelper.getConnection();
            pst = conn.prepareStatement("SELECT Vendor_Name FROM Vendor where Vendor_ID = ?");
            pst.setString(1, s);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return rs;
    }
}
