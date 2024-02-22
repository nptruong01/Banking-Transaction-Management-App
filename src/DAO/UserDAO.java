/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
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
public class UserDAO extends Connect{
    public int tongsp(String masp)
    {/////
      /*  if OBJECT_ID('demsosanpham') is not null
drop proc demsosanpham
go
create Proc demsosanpham
@madm nchar(10),@sosanpham int output 
as
select @sosanpham=count(masp) from sanpham,danhmuc
where sanpham.madm=danhmuc.madm and sanpham.madm=@madm

declare @sosanpham int
exec demsosanpham 'dmgd', @sosanpham output 
select @sosanpham as cot
     //////   
 */       
        
        int tongsp1=0;
        String sql="{call demsosanpham(?,?)}";
        try {
            CallableStatement stml =con.prepareCall(sql);
        stml.setString(1,masp);
        stml.registerOutParameter(2,java.sql.Types.INTEGER);
        stml.execute();
        tongsp1=stml.getInt(2);
        stml.close();
        con.close();
        
        } 
        catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tongsp1;
    }
    
    public ArrayList<User> docdanhsachuser(){
        ArrayList<User> dssp = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User o = new User();
                
                o.setUser_id(rs.getString("user_id"));
                o.setHo(rs.getString("ho"));
                o.setTen(rs.getString("ten"));
                o.setStreet(rs.getString("street"));
                o.setPhone(rs.getString("phone"));                
                o.setUsername(rs.getString("username"));
                o.setPass(rs.getString("pass"));
                o.setPhanquyen(rs.getString("phanquyen"));
                o.setBranch_id(rs.getString("branch_id"));

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
    
    public String AutoID() {
    String newID = "USER001";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(user_id) AS maxID FROM [user]");
        if (rs.next()) {
            String maxID = rs.getString("maxID");
            if (maxID != null) {
                int id = Integer.parseInt(maxID.substring(4));
                id++;
                newID = String.format("USER%03d", id);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newID;
}


    
    public int luuUser(User sp)
    {
        try
        {
            String sql="Insert into \"user\" values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getUser_id());
            preStatement.setString(2, sp.getHo());
            preStatement.setString(3, sp.getTen());
            preStatement.setString(4, sp.getStreet());
            preStatement.setString(5, sp.getPhone());
            preStatement.setString(6, sp.getUsername());
            preStatement.setString(7, sp.getPass());
            preStatement.setString(8, sp.getPhanquyen());
            preStatement.setString(9, sp.getBranch_id());

             return preStatement.executeUpdate();                   
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }    
    public int capnhatUser(User sp)    
    {
        
    try
    {
    String sql="Update \"user\" set ho=?,ten=?,street=?,phone=?,username=?,pass=?,phanquyen=?,branch_id=? where user_id=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
                         
            preStatement.setString(1, sp.getHo());
            preStatement.setString(2, sp.getTen());
            preStatement.setString(3, sp.getStreet());
            preStatement.setString(4, sp.getPhone());
            preStatement.setString(5, sp.getUsername());
            preStatement.setString(6, sp.getPass());
            preStatement.setString(7, sp.getPhanquyen());
            preStatement.setString(8, sp.getBranch_id());
            preStatement.setString(9, sp.getUser_id());
            
            return preStatement.executeUpdate();    
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
    
     public boolean XoaUser(String maTK) {
        try {
            String sql = "Delete from \"user\" where user_id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maTK);

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
