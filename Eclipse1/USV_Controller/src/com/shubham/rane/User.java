package com.shubham.rane;
import java.util.Date;

public class User {

	private String uName;
	private String pwd;
	private String creatorID = Login.UNAME;
	private Date creationDate = java.util.Calendar.getInstance().getTime();
	private String role;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCreatorID() {
		return creatorID;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uName=" + uName + ", pwd=" + pwd + ", creatorID=" + creatorID + ", creationDate=" + creationDate
				+ ", role=" + role + "]";
	}
	
	
	
}
