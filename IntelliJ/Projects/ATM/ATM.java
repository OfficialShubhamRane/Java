/**
 * ATM
 */
import java.text.ChoiceFormat;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Bank theBank = new Bank("Bank of America");

        User aUser = theBank.addUser("Shubham,", "Rane", "1234");
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while(true){
            curUser = ATM.mainMenuPrompt(theBank, sc);

            ATM.printUserMenu(curUser, sc);
        }
    }

    public static  User mainMenuPrompt(Bank theBank, Scanner sc){
        String userID;
        String pin;
        User authUser;

        //prompt user for userID/pin combo until the correct one is reached
        do{

            System.out.printf("\n\n Welcome to %s ATM\n\n",theBank.getBankName());
            System.out.println("Enter UserID: ");
            userID = sc.nextLine();
            System.out.println("Enter Pin: ");
            pin = sc.nextLine();

            authUser = theBank.userLogin(userID, pin);
            if(authUser == null){
                System.out.println("Incorrect userID or PIN");
            }
        }while(authUser == null); // continue until successful login
        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc){
        theUser.printAccountsSummary();

        int choice;
        //user menu

        do{
            System.out.println("Below are your option...");
            System.out.println("1. TRANSACTION HISTORY");
            System.out.println("2. WITHDRAW");
            System.out.println("3. DEPOSIT");
            System.out.println("4. TRANSFER");
            System.out.println("5. QUIT");
            choice = sc.nextInt();
        }while(choice != 5);

        //process the choice
        switch(){
            case 1:
                ATM.showTransactionHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;
        }

        if(choice != 5){
            ATM.printUserMenu(theUser, sc);
        }

    }

}