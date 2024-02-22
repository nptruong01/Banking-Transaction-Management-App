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
    public class Xacthuc {
        private String id;
	private String acc_id;
	private String toacc_id;
	private String type;
	private String date;
	private int amount;
	private String branch_id;
        private String email;
        private String isDone;
        private String code;

    public Xacthuc() {
    }

    
    
    public Xacthuc(String id, String acc_id, String toacc_id, String type, String date, int amount, String branch_id,String email,String code,String isDone) {
        this.id = id;
        this.acc_id = acc_id;
        this.toacc_id = toacc_id;
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.branch_id = branch_id;
        this.email = email;
        this.code = code;
        this.isDone = isDone;
        
    }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        
        
        public String getIsDone() {
            return isDone;
        }

        public void setIsDone(String isDone) {
            this.isDone = isDone;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
        
        
        
        @Override
    public String toString() {
        return id;
    }   
}
