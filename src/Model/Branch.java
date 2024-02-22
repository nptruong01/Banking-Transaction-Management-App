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
public class Branch {
        private String branch_id;
	private String location;
	private String address;

    public Branch(String branch_id, String location, String address) {
        this.branch_id = branch_id;
        this.location = location;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Branch{" + "branch_id=" + branch_id + ", location=" + location + ", address=" + address +'}';
    }
    
    public Branch() {
    }
    
    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
//    @Override
//    public String toString() {
//        return branch_id;
//    }
}
    
 
