/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class BuyerDao {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    //get buyer table max row
    public int getMaxRow(){
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(bid) from buyer");
            while(rs.next()){
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuyerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    
    //get buyer values
    public String[] getUserValue(int id){
        String[] value = new String[6];
        try{
            ps = con.prepareStatement("select * from buyer where bid =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                value[0] = rs.getString(1);
                value[1] = rs.getString(2);
                value[2] = rs.getString(3);
                value[3] = rs.getString(4);
                value[4] = rs.getString(5);
                value[5] = rs.getString(6);
            }
        }catch (SQLException ex) {
            Logger.getLogger(SellerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    //insert data into buyer table
    public void insert(String email, String address, int acc_id, String phone, String name){
        String sql = "insert into buyer values(?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,address);
            ps.setInt(3, acc_id);
            ps.setString(4, phone);
            ps.setString(5, name);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Completed");
            }else{
                JOptionPane.showMessageDialog(null, "Cannot stored");
            }
        }catch(SQLException ex){
            Logger.getLogger(BuyerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    //get buyer id
    public int getUserId(int accountId){
        int id = 0;
        try{
            ps = con.prepareStatement("select bid from buyer where acc_id =?");
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(BuyerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public String getAddress(int id){
        String address = "";
        try{
            ps = con.prepareStatement("select uaddress from buyer where bid =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                address = rs.getString(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(BuyerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return address;
    }
    
    public String getEmail(int id){
        String email = "";
        try{
            ps = con.prepareStatement("select uemail from buyer where bid =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                email = rs.getString(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(BuyerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return email;
    }
}
