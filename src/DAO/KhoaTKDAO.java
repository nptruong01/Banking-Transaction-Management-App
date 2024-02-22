/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI-VN
 */
public class KhoaTKDAO extends Connect{
    public ArrayList<Account> loadTK(){
        ArrayList<Account> dssp = new ArrayList<>();
        String sql = "SELECT a.acc_id,a.cust_id, c.ho, c.ten, a.balance, a.trangthai\n" +
                    "FROM account a \n" +
                    "INNER JOIN customer c ON a.cust_id = c.cust_id \n" +
                    "WHERE a.trangthai = 'Active'";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account o = new Account();
                Customer c = new Customer();
                
                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                c.setHo(rs.getString("ho"));
                c.setTen(rs.getString("ten"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));

                o.setCustomer(c);
                dssp.add(o);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
    
public ArrayList<Account> timtheoten(String ten) {
    ArrayList<Account> dssp = new ArrayList<Account>();
    try {
        String sql = "SELECT a.acc_id,a.cust_id, c.ho, c.ten, a.balance, a.trangthai\n" +
"                     FROM account a \n" +
"                     INNER JOIN customer c ON a.cust_id = c.cust_id \n" +
"                     WHERE a.trangthai = 'Active' and c.ten LIKE ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "%" + ten + "%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                Account o = new Account();
                Customer c = new Customer();
                
                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                c.setHo(rs.getString("ho"));
                c.setTen(rs.getString("ten"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));

                o.setCustomer(c);
                dssp.add(o);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return dssp;
}
        
    public ArrayList<Account> loadTKKhoa(){
        ArrayList<Account> dssp = new ArrayList<>();
        String sql = "SELECT a.acc_id,a.cust_id, c.ho, c.ten, a.balance, a.trangthai\n" +
                    "FROM account a \n" +
                    "INNER JOIN customer c ON a.cust_id = c.cust_id \n" +
                    "WHERE a.trangthai = 'Block'";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account o = new Account();
                Customer c = new Customer();
                
                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                c.setHo(rs.getString("ho"));
                c.setTen(rs.getString("ten"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));

                o.setCustomer(c);
                dssp.add(o);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return dssp;
    }
    
public ArrayList<Account> timtheotenKhoa(String ten) {
    ArrayList<Account> dssp = new ArrayList<Account>();
    try {
        String sql = "SELECT a.acc_id,a.cust_id, c.ho, c.ten, a.balance, a.trangthai\n" +
                " FROM account a \n" +
                " INNER JOIN customer c ON a.cust_id = c.cust_id \n" +
                " WHERE a.trangthai = 'Block' and c.ten LIKE ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "%" + ten + "%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
                Account o = new Account();
                Customer c = new Customer();
                
                o.setAcc_id(rs.getString("acc_id"));
                o.setCust_id(rs.getString("cust_id"));
                c.setHo(rs.getString("ho"));
                c.setTen(rs.getString("ten"));
                o.setBalance(rs.getInt("balance"));
                o.setTrangthai(rs.getString("trangthai"));

                o.setCustomer(c);
                dssp.add(o);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return dssp;
}
    
}
