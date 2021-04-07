package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private String name;
	private int rollNo;
	private String branch;
	
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", branch=" + branch + "]";
	}
	
	public void show() {
		System.out.println("Showing");
	}
		
}
