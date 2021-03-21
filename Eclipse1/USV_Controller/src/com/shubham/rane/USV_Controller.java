package com.shubham.rane;

import java.util.Scanner;

public class USV_Controller {
	
	
	public static void main(String[] args) {
		
		Login loginObject = new Login();
		User userObject = new User();
		Machine machineObject = new Machine();
		
		
		Scanner sc = new Scanner(System.in);
		
		String role = loginObject.verifyUser();
				
		String choice ="#";
		System.out.println("Press 1 to create user");
		System.out.println("Press 2 to create machine");
		System.out.println("Press 3 to deploy machine");
		System.out.println("Press 0 to exit the program");
		choice = sc.nextLine();
		
		if(choice.equals("3")) {
			System.out.println("I am a operator");
			MachineControl machineControlObject = new MachineControl();
			
			
		}else if (choice.equals("0")) {
			USV_Controller.exit();
		}
		
		while( choice.equals("1") || choice.equals("2")) {
			
			choice = sc.nextLine();
			System.out.println("Press 1 to create user");
			System.out.println("Press 2 to create machine");
			System.out.println("Press 0 to exit the program");
			
			if (choice.equals("1") && (role.equals("master") || role.equals("admin")) ) {
				System.out.println("Create uName for new User");
				userObject.setuName(sc.nextLine());
				System.out.println("Create pwd for new User");
				userObject.setPwd(sc.nextLine());
				System.out.println("Give role to new User");
				userObject.setRole(sc.nextLine());
				
				System.out.println("New User created with following details: ");
				System.out.println(userObject.toString());
				
			} else if(choice.equals("2") && (role.equals("master") || role.equals("admin"))){
				
				System.out.println("Create new machine ID");
				machineObject.setMachineID(sc.nextLine());
				
				System.out.println("New Machine Created with following details: ");
				System.out.println(machineObject.toString());

			} 
			
		} //while
		
	} //main
	
	public static void exit() {
		System.err.println("Exited from the program");
		
	}

}
