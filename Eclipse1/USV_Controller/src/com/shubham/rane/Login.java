package com.shubham.rane;

import java.util.Scanner;

public class Login {
	
	static String UNAME = "Shubham";
	static String PWD = "1234";
	static String role = "master";
	
	public String verifyUser(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the valid UserName");
		String uName = sc.nextLine();
		System.out.println("Enter the valid Password");
		String pwd = sc.nextLine();
		
		if(uName.equals(UNAME) && pwd.equals(PWD)) {
			System.out.println("Login Successful");
			return role;
		}
		
		System.out.println("Login Unsuccessful");
		return role;
	}
	
}
