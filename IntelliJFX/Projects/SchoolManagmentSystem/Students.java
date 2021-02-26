import java.util.Scanner;
public class Students {
    private String sFirstName;
    private String sLastName;
    private String sId;
    private String courses="";
    private int gradeYear;
    private int tuitionBalance;
    private static int courseFee = 600;    
    private static int ID = 1000;
    private String coursEntered;
    
    /**
     * Ask for name and graduation year 
     */
    public Students(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student first name: ");
        this.sFirstName  = sc.nextLine();
        System.out.println("Enter Student last name: ");
        this.sLastName  = sc.nextLine();
        System.out.println("1.Freshman \n2.Sophomore \n3.Junior \n4.Senior \nChoose Student class level: ");
        this.gradeYear  = sc.nextInt();
        setStudentID();
        System.out.println(sFirstName +" "+ sLastName +" "+ gradeYear +" "+ sId);
    }

    //Generate an ID
    void setStudentID(){
        ID++;
        this.sId = gradeYear + "" + ID;
    }

    //Enroll in courses
    void enrollCourses(){
    do{  
        System.out.print("Enter course name to enroll or Q to quit: ");
        Scanner sc = new Scanner(System.in);
        
        coursEntered = sc.nextLine();
        if(!coursEntered.equals("Q")){
            courses = courses + " " + coursEntered;
            tuitionBalance += courseFee;
        }else{
            break;
        }
    }while(1 != 0);
    }

    //View balance
    void viewBalance(){
        System.out.println(sFirstName +" "+ sLastName + "'s remaining balance is $"+tuitionBalance +".");
    }

    //Pay tuition
    void payTution(){
        viewBalance();
        System.out.print("Make payment of: $");
        Scanner sc = new Scanner(System.in);
        int payment = sc.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment for $"+payment+".");
        viewBalance();
    }

    void viewInfo(){
        System.out.println("Student ID: " + sId);
        System.out.println("Name: " + sFirstName +" "+ sLastName);
        System.out.println("Conurses Enrolled: "+ courses+".");
        System.out.println(sFirstName +" "+ sLastName + "'s remaining balance is $"+tuitionBalance +".");

    }

}
