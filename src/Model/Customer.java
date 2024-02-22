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
public class Customer {
    private String cust_id;
    private String ho;
    private String ten;
    private String cmnd;
    private String street;
    private String phone;
    private String gioitinh;
    private String email;   

    public Customer(String cust_id, String ho, String ten, String cmnd, String street, String phone, String gioitinh,String email) {
        this.cust_id = cust_id;
        this.ho = ho;
        this.ten = ten;
        this.cmnd = cmnd;
        this.street = street;
        this.phone = phone;
        this.gioitinh = gioitinh;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "cust_id=" + cust_id + ", ho=" + ho + ", ten=" + ten + ", cmnd=" + cmnd + ", street=" + street 
                +", phone=" + phone +", gioitinh=" + gioitinh +", email=" + email +'}';
    }
    
    public Customer() {
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

	public String getCmnd() {
		return this.cmnd;
	}

	/**
	 * 
	 * @param cmnd
	 */
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
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

	public String getGioitinh() {
		return this.gioitinh;
	}

	/**
	 * 
	 * @param gioitinh
	 */
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        
        
//       @Override
//    public String toString() {
//        return cust_id;
//    }
}
