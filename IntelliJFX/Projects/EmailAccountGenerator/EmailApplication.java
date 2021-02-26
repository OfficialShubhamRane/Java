import java.util.Scanner;
public class EmailApplication {
    
    private String firstName, lastName, department="";
    private String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
    private int defaultPWDsize = 10;
    private  char[] password = new char[defaultPWDsize];
    private int mailboxCapacity = 500;
    private String altEmailAddress;

    public static void main(String[] args) {
        
        EmailApplication obj = new EmailApplication();
        System.out.println("New Email address is: " + obj.generateEmail());
        System.out.println("Your default password is " + obj.generatePassword());

    }

    String generateEmail(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        firstName = sc.next();
        System.out.println("Enter Last Name: ");
        lastName = sc.next();
        System.out.println("Department codes: \n1. sales \n2. dev \n3. accounts");
        char option = sc.next().charAt(0);

        switch(option){
            case '1':
                department = "sales";
                break;
            case '2':
                department = "development";
                break;
            case '3':
                department = "accounts";
                break;
            default:
                department = "";
                break;
        }
    
        return firstName.toLowerCase() +"."+ lastName.toLowerCase() +"@"+ department +"."+ "HibuscusCorp.com";

    }

    String generatePassword(){
       
        int rand;

        for(int i=0; i < defaultPWDsize; i++){
            rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    void setAltEmailAddress(String altEmail){
        this.altEmailAddress = altEmail;
    }

    void changePassword(String password){
        this.password = password.toCharArray();
    }
    
}