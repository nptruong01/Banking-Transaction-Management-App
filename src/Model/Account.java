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
public class Account {
    private String acc_id;
	private String cust_id;
	private int balance;
	private String trangthai;
        private Customer customer;


    public Account(String acc_id, String cust_id, int balance, String trangthai) {
        this.acc_id = acc_id;
        this.cust_id = cust_id;
        this.balance = balance;
        this.trangthai = trangthai;
    }

    public Account() {
    }    
        
	public String getAcc_id() {
		return this.acc_id;
	}

	/**
	 * 
	 * @param acc_id
	 */
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}

	public String getCust_id() {
		return this.cust_id;
	}

	/**
	 * 
	 * @param cust_id
	 */
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public int getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getTrangthai() {
		return this.trangthai;
	}

	/**
	 * 
	 * @param trangthai
	 */
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
        public Customer getCustomer() {
            return this.customer;
        }
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
        
         @Override
    public String toString() {
        return acc_id;
    }
}
