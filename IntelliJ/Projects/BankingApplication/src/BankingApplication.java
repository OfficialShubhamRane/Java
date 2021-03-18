import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankAccount ac = new BankAccount();
		ac.credentials();
		ac.showMenu();
	}
}

class BankAccount{
	String customerNo;
	String customerName;
	int balance;
	int previousTranaction;
	
	void credentials() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Account number: ");
		customerNo = sc1.next();
		System.out.println("Enter Account holder name: ");
		customerName = sc1.next();
	}
	
	void deposit(int amount) {
		if(amount > 0) {
			balance += amount;
			previousTranaction = amount;
			System.out.println("Amount deposited: " + amount);
		}else {
			System.out.println("Amount entered is too low to process.");
		}
		System.out.println("Current Balance: " + balance);
	}
	
	void withdraw(int amount) {
		if(balance >= amount ) {
			balance -= amount;
			System.out.println("Amount withdrawn: " + amount);
			previousTranaction = -amount;
		}
		else if(balance < amount) {
			System.out.println("Couldn't complete the transaction as balance is lesser than amount entered.");
		}
		else if(amount == 0) {
			System.out.println("Amount enetered is too low");
		}
		System.out.println("Current Balance: " + balance);
	}
	
	void getPreviousTransaction() {
		if(previousTranaction > 0) {
			System.out.println("Deposited: " + previousTranaction);
		}
		else if(previousTranaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTranaction));
		}else {
			System.out.println("No transaction occured");
		}
	}

	void showMenu() {
		
		String option = "\0";
		int amount;
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Account Number: " + customerNo);
		System.out.println("Account holder Name: " + customerName); 
		System.out.print("\n");
		System.out.println("1. Deposite");
		System.out.println("2. Withdraw");
		System.out.println("3. CheckBalance");
		System.out.println("4. Check previous Transaction");
		System.out.println("5. Exit");
		
		
		while(option != "5"){
			option = sc.next();	
			switch(option) {
			case "1":
				System.out.println("Enter amount to be deposited");
				amount = sc.nextInt();
				System.out.println("===================================================================");
				deposit(amount);
				System.out.println("\n");
				System.out.println("===================================================================");
				break;
				
			case "2":
				System.out.println("Enter amount to be withdrawn");
				amount = sc.nextInt();
				System.out.println("===================================================================");
				withdraw(amount);
				System.out.println("\n");
				System.out.println("===================================================================");
				break;
				
			case "3":
				System.out.println("Balance: " + balance);
				System.out.println("===================================================================");
				System.out.println("\n");
				System.out.println("===================================================================");
				break;

			case "4":
				getPreviousTransaction();
				System.out.println("\n");
				break;
				
			case "5":
				System.out.println("===================================================================");
				System.out.println("Thank you for using out services");
				System.out.println("===================================================================");
				System.out.print("\n");
				showMenu();
				break;
				
			default:
				System.out.println("Invalid option chosen");
				System.out.println("\n");
				break;
				
			}
		}
	
	}
}	