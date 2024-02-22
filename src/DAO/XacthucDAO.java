/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import Model.Account;
import Model.Xacthuc;
//import Model.Customer;
//import Model.Giaodich;
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
public class XacthucDAO extends Connect{
public ArrayList<String> getTransactions() {
    ArrayList<String> transactions = new ArrayList<>();
//       String sql = "SELECT g.user_id, DATEDIFF(MINUTE, g.date, GETDATE()) AS time_diff " +
//                 "FROM xacthuc x " +
//                 "INNER JOIN giaodich g ON x.date = g.date " +
//                 "WHERE x.isDone = 0";
        String sql = "SELECT gd_id,user_id, DATEDIFF(MINUTE, date, GETDATE()) AS time_diff \n" +
                        "FROM giaodich ORDER BY date DESC;";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String GDId = rs.getString("gd_id");
            String userId = rs.getString("user_id");
            int timeDiff = rs.getInt("time_diff");
            String transaction =GDId + " hoàn thành " + timeDiff + " phút trước bởi "+userId;
            transactions.add(transaction);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return transactions;
}

  public Xacthuc getXacthuc(String id, String acc_id, String date, int amount, String branch_id, String email, String code) {
        Xacthuc xacthuc = null;
        try {
            String sql = "SELECT id, acc_id, date, amount, branch_id, email, code " +
                         "FROM xacthuc " +
                         "WHERE id = ? AND acc_id = ?  AND date = ? AND amount = ? AND branch_id = ? AND email = ?  AND code = ?;";
            PreparedStatement preStatement = con.prepareStatement(sql);
            preStatement.setString(1, id);
            preStatement.setString(2, acc_id);
            preStatement.setString(3, date);
            preStatement.setInt(4, amount);
            preStatement.setString(5, branch_id);
            preStatement.setString(6, email);
            preStatement.setString(7, code);
            ResultSet rs = preStatement.executeQuery();
            
            if (rs.next()) {
                xacthuc = new Xacthuc();
                xacthuc.setId(rs.getString("id"));
                xacthuc.setAcc_id(rs.getString("acc_id"));
                xacthuc.setDate(rs.getString("date"));
                xacthuc.setAmount(rs.getInt("amount"));
                xacthuc.setBranch_id(rs.getString("branch_id"));
                xacthuc.setEmail(rs.getString("email"));
                xacthuc.setCode(rs.getString("code"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return xacthuc;
    }
//    public String AutoID() {
//    String newID = "GD001";
//    try {
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select Max(gd_id)as maxID from giaodich ");
//        if (rs.next()) {
//            String maxID = rs.getString("maxID");
//            if (maxID != null) {
//                int id = Integer.parseInt(maxID.substring(2));
//                id++;
//                newID = String.format("GD%03d", id);
//            }
//        }
//    } catch (SQLException ex) {
//        Logger.getLogger(XacthucDAO.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return newID;
//}


    
//    public int naptien(Giaodich sp)
//    {
//        try
//        {
//            String sql="insert into giaodich values(?, ?, null,'naptien',?,?,?)";
//            PreparedStatement preStatement =con.prepareStatement(sql);
//            
//            preStatement.setString(1, sp.getGd_id());
//            preStatement.setString(2, sp.getAcc_id());
//            preStatement.setString(3, sp.getDate());
//            preStatement.setInt(4, sp.getAmount());
//            preStatement.setString(5, sp.getBranch_id());
//
//             return preStatement.executeUpdate(); 
//             
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        return -1;
//    } 
    
    public int xacthucruttien(Xacthuc sp)
    {
        try
        {
            String sql="insert into xacthuc values(?, ?, null,'ruttien',?,?,?,?,?,0)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getId());
            preStatement.setString(2, sp.getAcc_id());
            preStatement.setString(3, sp.getDate());
            preStatement.setInt(4, sp.getAmount());
            preStatement.setString(5, sp.getBranch_id());
            preStatement.setString(6, sp.getEmail());
            preStatement.setString(7, sp.getCode());

             return preStatement.executeUpdate(); 
             
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }  

    public int chuyenkhoan(Xacthuc sp)
    {
        try
        {
            String sql="insert into giaodich values(?, ?, ?,'chuyentien',?,?,?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getId());
            preStatement.setString(2, sp.getAcc_id());
            preStatement.setString(3, sp.getToacc_id());
            preStatement.setString(4, sp.getDate());
            preStatement.setInt(5, sp.getAmount());
            preStatement.setString(6, sp.getBranch_id());
            preStatement.setString(6, sp.getIsDone());
            preStatement.setString(7, sp.getCode());

             return preStatement.executeUpdate();                   
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    } 
    
//    public int congtien(Giaodich sp)    
//    {
//        
//    try
//    {
//    String sql="UPDATE account SET  balance = balance+?  WHERE acc_id = ?";
//            PreparedStatement preStatement=con.prepareStatement(sql);
//                                 
//            preStatement.setInt(1, sp.getAmount());
//            preStatement.setString(2, sp.getAcc_id());        
//            
//            
//            return preStatement.executeUpdate();    
//    }
//    catch(Exception ex)
//    {
//        ex.printStackTrace();
//        
//    }
//        return -1;
//    }
//    
//        public int congtienchuyenkhoan(Giaodich sp)    
//    {
//        
//    try
//    {
//    String sql="UPDATE account SET  balance = balance+?  WHERE acc_id = ?";
//            PreparedStatement preStatement=con.prepareStatement(sql);
//                                 
//            preStatement.setInt(1, sp.getAmount());
//            preStatement.setString(2, sp.getToacc_id());        
//            
//            
//            return preStatement.executeUpdate();    
//    }
//    catch(Exception ex)
//    {
//        ex.printStackTrace();
//        
//    }
//        return -1;
//    }
//    
//    public int trutien(Giaodich sp)    
//    {
//        
//    try
//    {
//    String sql="UPDATE account SET  balance = balance-?  WHERE acc_id = ?";
//            PreparedStatement preStatement=con.prepareStatement(sql);
//                         
//            preStatement.setInt(1, sp.getAmount());
//            preStatement.setString(2, sp.getAcc_id());
//            
//            return preStatement.executeUpdate();    
//    }
//    catch(Exception ex)
//    {
//        ex.printStackTrace();
//        
//    }
//        return -1;
//    }
}
