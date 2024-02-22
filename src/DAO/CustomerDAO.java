/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
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
public class CustomerDAO extends Connect{
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
    
    public ArrayList<Customer> docdanhsachsp(){
        ArrayList<Customer> dssp = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer o = new Customer();

                o.setCust_id(rs.getString("cust_id"));
                o.setHo(rs.getString("ho"));
                o.setTen(rs.getString("ten"));
                o.setCmnd(rs.getString("cmnd"));
                o.setStreet(rs.getString("street"));
                
                o.setPhone(rs.getString("phone"));
                o.setGioitinh(rs.getString("gioitinh"));
                o.setEmail(rs.getString("email"));

                dssp.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
    
    
//    public ArrayList<Customer> AutoID(){
//        ArrayList<Customer> dssp = new ArrayList<>();
//        String sql = "select Max(cust_id)as 'MAX(id)' from customer";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Customer o = new Customer();
//   
//                o.setCust_id(rs.getString("MAX(id)"));
//                dssp.add(o);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//              return dssp;
//    }
    
    public String AutoID() {
    String newID = "KH001";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(cust_id) AS maxID FROM customer");
        if (rs.next()) {
            String maxID = rs.getString("maxID");
            if (maxID != null) {
                int id = Integer.parseInt(maxID.substring(2));
                id++;
                newID = String.format("KH%03d", id);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newID;
}
    
    public ArrayList<Customer> docdanhsachsptheodm(String madm)
    {
        ArrayList<Customer> dssp = new ArrayList<Customer>();
        try
        {
            String sql="SELECT * FROM customer where cust_id=? ";
          PreparedStatement pstm=con.prepareStatement(sql);
          pstm.setString(1,madm);
          ResultSet rs= pstm.executeQuery();
          while(rs.next())
          {
              Customer sp= new Customer();
              sp.setCust_id(rs.getString(1));
              sp.setHo(rs.getString(2));
              sp.setTen(rs.getString(3));
              sp.setCmnd(rs.getString(4));
              sp.setStreet(rs.getString(5));
              sp.setPhone(rs.getString(6));
              sp.setGioitinh(rs.getString(7));
              sp.setEmail(rs.getString(8));
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
    
    public int luusanpham(Customer sp)
    {
        try
        {
            String sql="insert into customer values(?,?,?,?,?,?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            preStatement.setString(1, sp.getCust_id());
            preStatement.setString(2, sp.getHo());
            preStatement.setString(3, sp.getTen());
            preStatement.setString(4, sp.getCmnd());
            preStatement.setString(5, sp.getStreet());
            preStatement.setString(6, sp.getPhone());
            preStatement.setString(7, sp.getGioitinh());
            preStatement.setString(8, sp.getEmail());

             return preStatement.executeUpdate();
                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }    
    public int capnhatsanpham(Customer sp)    
    {
        
    try
    {
        String sql="update customer set ho=?, ten=?,cmnd=?, street=?, phone=?, gioitinh=?, email=? where cust_id=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
   
            preStatement.setString(1, sp.getHo());
            preStatement.setString(2, sp.getTen());
            preStatement.setString(3, sp.getCmnd());
            preStatement.setString(4, sp.getStreet());
            preStatement.setString(5, sp.getPhone());
            preStatement.setString(6, sp.getGioitinh());
            preStatement.setString(7, sp.getEmail());
            preStatement.setString(8, sp.getCust_id());
             return preStatement.executeUpdate();
                
        
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
    
     public boolean XoaSanPham(String maSP) {
        try {
            String sql = "delete from customer where cust_id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setBoolean(1, true);
            pstm.setString(1, maSP);

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
