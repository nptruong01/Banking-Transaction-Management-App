/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI-VN
 */
public class AccountDAO extends Connect{
   
    public ArrayList<Account> docdanhsachtk(){
        ArrayList<Account> dssp = new ArrayList<>();
        String sql = "  SELECT * FROM account where trangthai='Active' ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account o = new Account();

                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));

                dssp.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
    
//    public ArrayList<Account> docdanhsachtkblock(){
//        ArrayList<Account> dssp = new ArrayList<>();
//        String sql = "  SELECT * FROM account where trangthai='Block' ";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Account o = new Account();
//
//                o.setAcc_id(rs.getString("acc_id"));
//                o.setCust_id(rs.getString("cust_id"));
//                o.setBalance(rs.getInt("balance"));
//                o.setTrangthai(rs.getString("trangthai"));
//
//                dssp.add(o);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//              return dssp;
//    }
    
    public ArrayList<Account> docdanhsachtktheoma(String madm)
    {
        ArrayList<Account> dssp = new ArrayList<Account>();
        try
        {
            String sql="SELECT * FROM account where acc_id=? and trangthai='Active'";
          PreparedStatement pstm=con.prepareStatement(sql);
          pstm.setString(1,madm);
          ResultSet rs= pstm.executeQuery();
          while(rs.next())
          {
              Account sp= new Account();
          
              sp.setAcc_id(rs.getString(1));
              sp.setCust_id(rs.getString(2));
              sp.setBalance(rs.getInt(3));
              sp.setTrangthai(rs.getString(4));
             
//              sp.setIsdelete(0);
              dssp.add(sp);
                           
          }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dssp;
    }
    
    
  
//     public ArrayList<SanPham> timtheoten(String tensp)
//    {
//        ArrayList<SanPham> dssp = new ArrayList<SanPham>();
//        try
//        {
//            String sql="SELECT * FROM sanpham where tensp like N'" + tensp +  "%'" ;// có chữ N ĐẰNG TRƯỚC LÀ TÌM UNICODE
//         
//         Statement statement= con.createStatement();
//           ResultSet rs =statement.executeQuery(sql);
//       
//         
//          while(rs.next())
//          {
//              SanPham sp= new SanPham();
//              sp.setMasp(rs.getString(1));
//              sp.setTensp(rs.getString(2));
//              sp.setSoluong(rs.getInt(3));
//              sp.setDongia(rs.getInt(4));
//              sp.setMadm(rs.getString(5));
//              sp.setIsdelete(0);
//              dssp.add(sp);
//                    
//                           
//          }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return dssp;
//    }
    
    public int luutaikhoan(Account sp)
    {
        try
        {
            String sql="insert into account values(?,?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getAcc_id());
            preStatement.setString(2, sp.getCust_id());
            preStatement.setInt(3, sp.getBalance());
            preStatement.setString(4, sp.getTrangthai());

             return preStatement.executeUpdate();
                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }    
    public int capnhattaikhoan(Account sp)    
    {     
        try
        {
            String sql="update account set cust_id=?, balance=?,trangthai=? where acc_id=?";
                PreparedStatement preStatement=con.prepareStatement(sql);

                preStatement.setString(1, sp.getCust_id());
                preStatement.setInt(2, sp.getBalance());
                preStatement.setString(3, sp.getTrangthai());
                preStatement.setString(4, sp.getAcc_id());
                 return preStatement.executeUpdate();                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }
        return -1;
    }
    
    public int khoataikhoan(Account sp)    
    {     
        try
        {
            String sql="update account set trangthai='Block' where acc_id=?";
                PreparedStatement preStatement=con.prepareStatement(sql);

                preStatement.setString(1, sp.getAcc_id());
                 return preStatement.executeUpdate();                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }
        return -1;
    }
    
        public int motaikhoan(Account sp)    
    {     
        try
        {
            String sql="update account set trangthai='Active' where acc_id=?";
                PreparedStatement preStatement=con.prepareStatement(sql);

                preStatement.setString(1, sp.getAcc_id());
                 return preStatement.executeUpdate();                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }
        return -1;
    }
    
     public boolean Xoataikhoan(String maTK) {
        try {
            String sql = "delete from account where acc_id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setBoolean(1, true);
            pstm.setString(1, maTK);

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
     
}
