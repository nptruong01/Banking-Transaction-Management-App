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
public class Giaodich {
        private String gd_id;
	private String acc_id;
	private String toacc_id;
	private String type;
	private String date;
	private int amount;
	private String user_id;

    public Giaodich() {
    }

    
    
    public Giaodich(String gd_id, String acc_id, String toacc_id, String type, String date, int amount, String user_id) {
        this.gd_id = gd_id;
        this.acc_id = acc_id;
        this.toacc_id = toacc_id;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.user_id = user_id;
    }

        
        
	public String getGd_id() {
		return this.gd_id;
	}

	/**
	 * 
	 * @param gd_id
	 */
	public void setGd_id(String gd_id) {
		this.gd_id = gd_id;
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

	public String getToacc_id() {
		return this.toacc_id;
	}

	/**
	 * 
	 * @param toacc_id
	 */
	public void setToacc_id(String toacc_id) {
		this.toacc_id = toacc_id;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
        
        @Override
    public String toString() {
        return gd_id;
    }
    

}
