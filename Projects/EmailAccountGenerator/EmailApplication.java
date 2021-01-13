import java.util.Scanner;
public class EmailApplication {

    public static void main(String[] args) {
        EmailApplication obj = new EmailApplication();
        obj.generateEmail();
    }

    void generateEmail(){
        String firstName, lastName, department=""; 
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
        
        System.out.println("New Email address is: ");
        System.out.println(firstName.toLowerCase() +"."+ lastName.toLowerCase() +"@"+ department +"."+ "HibuscusCorp.com");
        
    }
}