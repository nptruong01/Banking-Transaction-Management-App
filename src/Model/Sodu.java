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
public class Sodu {
    private String acc_id;
    private String cust_id;
    private String ho;
    private String ten;
    private String mail;
    private String cmnd;
    private String street;
    private String phone;
    private int balance;

    public Sodu(String acc_id, String cust_id, String ho, String ten, String mail, String cmnd,String street ,String phone,int balance) {
        this.acc_id = acc_id;
        this.cust_id = cust_id;
        this.ho = ho;
        this.ten = ten;
        this.mail = mail;
        this.cmnd = cmnd;
        this.street = street;
        this.phone = phone;
        this.balance = balance;
    }

    public Sodu() {
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
