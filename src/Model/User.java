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
public class User {
        private String user_id;
            private String ho;
            private String ten;
            private String street;
            private String phone;
            private String username;
            private String pass;
            private String phanquyen;
            private String branch_id;

        public User(String user_id, String ho, String ten, String street, String phone, String username, String pass, String phanquyen, String branch_id) {
            this.user_id = user_id;
            this.ho = ho;
            this.ten = ten;
            this.street = street;
            this.phone = phone;
            this.username = username;
            this.pass = pass;
            this.phanquyen = phanquyen;
            this.branch_id = branch_id;
        }

        public User() {
        }    
        
	public String getUser_id() {
		return this.user_id;
	}

	/**
	 * 
	 * @param user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getHo() {
		return this.ho;
	}

	/**
	 * 
	 * @param ho
	 */
	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return this.ten;
	}

	/**
	 * 
	 * @param ten
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getStreet() {
		return this.street;
	}

	/**
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return this.pass;
	}

	/**
	 * 
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhanquyen() {
		return this.phanquyen;
	}

	/**
	 * 
	 * @param phanquyen
	 */
	public void setPhanquyen(String phanquyen) {
		this.phanquyen = phanquyen;
	}

	public String getBranch_id() {
		return this.branch_id;
	}

	/**
	 * 
	 * @param branch_id
	 */
	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}
}
