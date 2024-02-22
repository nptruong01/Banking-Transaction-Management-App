/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI-VN
 */
public class CountDAO extends Connect{
public double demtk() {
    double count = 0;
    try {
        String sql = "SELECT COUNT(*) as maxID  FROM account";
        PreparedStatement preStatement = con.prepareStatement(sql);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            count = rs.getDouble("maxID");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return count;
}
public double demgd() {
    double count = 0;
    try {
        String sql = "SELECT COUNT(*) as maxID  FROM giaodich";
        PreparedStatement preStatement = con.prepareStatement(sql);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            count = rs.getDouble("maxID");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return count;
}
public double demcn() {
    double count = 0;
    try {
        String sql = "SELECT COUNT(*) as maxID  FROM chinhanh";
        PreparedStatement preStatement = con.prepareStatement(sql);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            count = rs.getDouble("maxID");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return count;
}
public double demnv() {
    double count = 0;
    try {
        String sql = "SELECT COUNT(*) as maxID  FROM [user]";
        PreparedStatement preStatement = con.prepareStatement(sql);
        ResultSet rs = preStatement.executeQuery();
        if (rs.next()) {
            count = rs.getDouble("maxID");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return count;
}
}
