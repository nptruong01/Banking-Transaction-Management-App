/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import Model.AccountCustomer;
import Model.Customer;
import Model.Giaodich;
import Model.Sodu;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI-VN
 */
public class GiaodichDAO extends Connect{

    
    public ArrayList<Giaodich> docdanhsachgiaodich(){
        ArrayList<Giaodich> dssp = new ArrayList<>();
        String sql = "SELECT * FROM giaodich";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Giaodich o = new Giaodich();
                
                o.setGd_id(rs.getString("gd_id"));
                o.setAcc_id(rs.getString("acc_id"));
                o.setToacc_id(rs.getString("toacc_id"));
                o.setType(rs.getString("type"));
                o.setDate(rs.getString("date"));
                o.setAmount(rs.getInt("amount"));
                o.setUser_id(rs.getString("user_id"));

                dssp.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
      
//     public ArrayList<User> timtheovitri(String location) {
//    ArrayList<User> dssp = new ArrayList<User>();
//    try {
//        String sql = "SELECT * FROM chinhanh WHERE location LIKE ?";
//        PreparedStatement statement = con.prepareStatement(sql);
//        statement.setString(1, "%" + location + "%");
//        ResultSet rs = statement.executeQuery();
//        while (rs.next()) {
//            Branch sp = new Branch();
//            sp.setBranch_id(rs.getString(1));
//            sp.setLocation(rs.getString(2));
//            sp.setAddress(rs.getString(3));
//            dssp.add(sp);
//        }
//    } catch (Exception ex) {
//        ex.printStackTrace();
//    }
//    return dssp;
//}
    
public ArrayList<Giaodich> timtheoma(String acc_id) {
    ArrayList<Giaodich> dssp = new ArrayList<Giaodich>();
    try {
        String sql = "SELECT * FROM giaodich where acc_id = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, acc_id );
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                Giaodich o = new Giaodich();
                
                o.setGd_id(rs.getString("gd_id"));
                o.setAcc_id(rs.getString("acc_id"));
                o.setToacc_id(rs.getString("toacc_id"));
                o.setType(rs.getString("type"));
                o.setDate(rs.getString("date"));
                o.setAmount(rs.getInt("amount"));
                o.setUser_id(rs.getString("user_id"));
                dssp.add(o);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return dssp;
}
public ArrayList<Giaodich> timtheonhanvien(String user_id) {
    ArrayList<Giaodich> dssp = new ArrayList<Giaodich>();
    try {
        String sql = "SELECT * FROM giaodich where user_id Like ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1,"%"+ user_id +"%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                Giaodich o = new Giaodich();
                
                o.setGd_id(rs.getString("gd_id"));
                o.setAcc_id(rs.getString("acc_id"));
                o.setToacc_id(rs.getString("toacc_id"));
                o.setType(rs.getString("type"));
                o.setDate(rs.getString("date"));
                o.setAmount(rs.getInt("amount"));
                o.setUser_id(rs.getString("user_id"));
                dssp.add(o);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return dssp;
}

public AccountCustomer laythongtin(String acc_id) {
    try {
        String sql = "SELECT a.acc_id, c.cust_id, c.ho, c.ten, c.email,c.cmnd, a.balance " +
                     "FROM account as a, customer as c " +
                     "WHERE a.cust_id = c.cust_id AND a.trangthai = 'Active' AND a.acc_id LIKE ?;";
        PreparedStatement preStatement = con.prepareStatement(sql);
        preStatement.setString(1, "%" + acc_id + "%");
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            String cust_id = rs.getString("cust_id");
            String ho = rs.getString("ho");
            String ten = rs.getString("ten");
            String mail = rs.getString("email");
            String cmnd = rs.getString("cmnd");
            int balance = rs.getInt("balance");
            AccountCustomer acc = new AccountCustomer(acc_id, cust_id, ho, ten,mail, cmnd, balance);
            return acc;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
public Sodu sodu1(String acc_id) {
    try {
        String sql = "SELECT a.acc_id, c.cust_id, c.ho, c.ten, c.email,c.cmnd,c.street,c.phone, a.balance " +
                     "FROM account as a, customer as c " +
                     "WHERE a.cust_id = c.cust_id AND a.trangthai = 'Active' AND a.acc_id = ?;";
        PreparedStatement preStatement = con.prepareStatement(sql);
        preStatement.setString(1, acc_id);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            String cust_id = rs.getString("cust_id");
            String ho = rs.getString("ho");
            String ten = rs.getString("ten");
            String mail = rs.getString("email");
            String cmnd = rs.getString("cmnd");
            String street = rs.getString("street");
            String phone = rs.getString("phone");
            int balance = rs.getInt("balance");
            Sodu acc = new Sodu(acc_id, cust_id, ho, ten,mail, cmnd,street,phone, balance);
            return acc;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}

public Sodu sodu2(String ten) {
    try {
        String sql = "SELECT a.acc_id, c.cust_id, c.ho, c.ten, c.email,c.cmnd,c.street,c.phone, a.balance " +
                     "FROM account as a, customer as c " +
                     "WHERE a.cust_id = c.cust_id AND a.trangthai = 'Active' AND c.ten = ?;";
        PreparedStatement preStatement = con.prepareStatement(sql);
        preStatement.setString(1,  ten );
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            String acc_id = rs.getString("acc_id");
            String cust_id = rs.getString("cust_id");
            String ho = rs.getString("ho");
//            String ten = rs.getString("ten");
            String mail = rs.getString("email");
            String cmnd = rs.getString("cmnd");
            String street = rs.getString("street");
            String phone = rs.getString("phone");
            int balance = rs.getInt("balance");
            Sodu acc = new Sodu(acc_id, cust_id, ho, ten,mail, cmnd,street,phone, balance);
            return acc;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}

public AccountCustomer laysodutheocmnd(String cmnd) {
    try {
        String sql = "SELECT a.acc_id, c.cust_id, c.ho, c.ten, c.email, c.cmnd, a.balance " +
                     "FROM account as a, customer as c " +
                     "WHERE a.cust_id = c.cust_id AND a.trangthai = 'Active' AND cmnd LIKE ?;";
        PreparedStatement preStatement = con.prepareStatement(sql);
        preStatement.setString(1, "%" + cmnd + "%");
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            String acc_id = rs.getString("acc_id");
            String cust_id = rs.getString("cust_id");
            String ho = rs.getString("ho");
            String ten = rs.getString("ten");
            String mail = rs.getString("email");
            int balance = rs.getInt("balance");
            AccountCustomer acc = new AccountCustomer(acc_id, cust_id, ho, ten,mail, cmnd, balance);
            return acc;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}



    
    public String AutoID() {
    String newID = "GD001";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Max(gd_id)as maxID from giaodich ");
        if (rs.next()) {
            String maxID = rs.getString("maxID");
            if (maxID != null) {
                int id = Integer.parseInt(maxID.substring(2));
                id++;
                newID = String.format("GD%03d", id);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(GiaodichDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newID;
}


    
    public int naptien(Giaodich sp)
    {
        try
        {
            String sql="insert into giaodich values(?, ?, null,'naptien',?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getGd_id());
            preStatement.setString(2, sp.getAcc_id());
            preStatement.setString(3, sp.getDate());
            preStatement.setInt(4, sp.getAmount());
            preStatement.setString(5, sp.getUser_id());

             return preStatement.executeUpdate(); 
             
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    } 
    
    public int ruttien(Giaodich sp)
    {
        try
        {
            String sql="insert into giaodich values(?, ?, null,'ruttien',?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getGd_id());
            preStatement.setString(2, sp.getAcc_id());
            preStatement.setString(3, sp.getDate());
            preStatement.setInt(4, sp.getAmount());
            preStatement.setString(5, sp.getUser_id());

             return preStatement.executeUpdate(); 
             
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }  

    public int chuyenkhoan(Giaodich sp)
    {
        try
        {
            String sql="insert into giaodich values(?, ?, ?,'chuyentien',?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getGd_id());
            preStatement.setString(2, sp.getAcc_id());
            preStatement.setString(3, sp.getToacc_id());
            preStatement.setString(4, sp.getDate());
            preStatement.setInt(5, sp.getAmount());
            preStatement.setString(6, sp.getUser_id());

             return preStatement.executeUpdate();                   
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    } 
    
    public int congtien(Giaodich sp)    
    {
        
    try
    {
    String sql="UPDATE account SET  balance = balance+?  WHERE acc_id = ?";
            PreparedStatement preStatement=con.prepareStatement(sql);
                                 
            preStatement.setInt(1, sp.getAmount());
            preStatement.setString(2, sp.getAcc_id());        
            
            
            return preStatement.executeUpdate();    
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
    
        public int congtienchuyenkhoan(Giaodich sp)    
    {
        
    try
    {
    String sql="UPDATE account SET  balance = balance+?  WHERE acc_id = ?";
            PreparedStatement preStatement=con.prepareStatement(sql);
                                 
            preStatement.setInt(1, sp.getAmount());
            preStatement.setString(2, sp.getToacc_id());        
            
            
            return preStatement.executeUpdate();    
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
    
    public int trutien(Giaodich sp)    
    {
        
    try
    {
    String sql="UPDATE account SET  balance = balance-?  WHERE acc_id = ?";
            PreparedStatement preStatement=con.prepareStatement(sql);
                         
            preStatement.setInt(1, sp.getAmount());
            preStatement.setString(2, sp.getAcc_id());
            
            return preStatement.executeUpdate();    
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
}
