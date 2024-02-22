/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Branch;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI-VN
 */
public class BranchDAO extends Connect{
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
    
    public ArrayList<Branch> docdanhsachcn(){
        ArrayList<Branch> dssp = new ArrayList<>();
        String sql = "SELECT * FROM chinhanh";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Branch o = new Branch();

                o.setBranch_id(rs.getString("branch_id"));
                o.setLocation(rs.getString("location"));
                o.setAddress(rs.getString("address"));

                dssp.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
      
     public ArrayList<Branch> timtheovitri(String location) {
    ArrayList<Branch> dssp = new ArrayList<Branch>();
    try {
        String sql = "SELECT * FROM chinhanh WHERE location LIKE ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "%" + location + "%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Branch sp = new Branch();
            sp.setBranch_id(rs.getString(1));
            sp.setLocation(rs.getString(2));
            sp.setAddress(rs.getString(3));
            dssp.add(sp);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return dssp;
}
    
    public String AutoID() {
    String newID = "CN001";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(branch_id) AS maxID FROM chinhanh");
        if (rs.next()) {
            String maxID = rs.getString("maxID");
            if (maxID != null) {
                int id = Integer.parseInt(maxID.substring(2));
                id++;
                newID = String.format("CN%03d", id);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newID;
}
    

    
    public int luuchinhanh(Branch sp)
    {
        try
        {
            String sql="Insert into chinhanh values(?,?,?)";
            PreparedStatement preStatement =con.prepareStatement(sql);
            
            preStatement.setString(1, sp.getBranch_id());
            preStatement.setString(2, sp.getLocation());
            preStatement.setString(3, sp.getAddress());

             return preStatement.executeUpdate();
                    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }    
    public int capnhatchinhanh(Branch sp)    
    {
        
    try
    {
        String sql="Update chinhanh set location=?,address=? where branch_id=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
              
            preStatement.setString(1, sp.getLocation());
            preStatement.setString(2, sp.getAddress());
            preStatement.setString(3, sp.getBranch_id());
            
            return preStatement.executeUpdate();    
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        
    }
        return -1;
    }
    
     public boolean Xoachinhanh(String maTK) {
        try {
            String sql = "Delete from chinhanh where branch_id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setBoolean(1, true);
            pstm.setString(1, maTK);

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
//    public String[] getAllBranchIds() {
//        String[] branchIds = null;
//    
//    try {
//        PreparedStatement ps = con.prepareStatement("SELECT branch_id FROM chinhanh", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet rs = ps.executeQuery();
//        
//        rs.last();
//        int numRows = rs.getRow();
//        branchIds = new String[numRows];
//        rs.beforeFirst();
//        
//        int i = 0;
//        while (rs.next()) {
//            branchIds[i++] = rs.getString(1);
//        }
//    } catch (SQLException ex) {
//        Logger.getLogger(BranchDAO.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    
//    return branchIds;
//    }
    
     public List<Branch> getAllBranchIds() {
        List<Branch> branches = new ArrayList<>();
       String sql = "SELECT * FROM chinhanh";
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Branch branch = new Branch();
            branch.setBranch_id(rs.getString("branch_id"));
            branches.add(branch);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branches;
    }
     
//         public ArrayList<Branch> getAllBranchIds(){
//        ArrayList<Branch> dssp1 = new ArrayList<>();
//        String sql = "SELECT * FROM chinhanh";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Branch o = new Branch();
//
//                o.setBranch_id(rs.getString("branch_id"));       
//
//                dssp1.add(o);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//              return dssp1;
//    }
}
