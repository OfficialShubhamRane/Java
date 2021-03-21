package com.shubham.rane;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student { //POJO for student
	
	@Id
	private int rollNo;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}
	
	
}
