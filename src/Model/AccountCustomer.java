/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MSI-VN
 */
public class AccountCustomer {
    private String acc_id;
    private String cust_id;
    private String ho;
    private String ten;
    private String mail;
    private String cmnd;
    private int balance;

    public AccountCustomer(String acc_id, String cust_id, String ho, String ten, String mail, String cmnd, int balance) {
        this.acc_id = acc_id;
        this.cust_id = cust_id;
        this.ho = ho;
        this.ten = ten;
        this.mail = mail;
        this.cmnd = cmnd;
        this.balance = balance;
    }

    public AccountCustomer() {
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountCustomer{" + '}';
    }
    
    
}
