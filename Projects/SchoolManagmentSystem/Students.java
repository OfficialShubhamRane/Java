import java.util.Scanner;
public class Students {
    private String sFirstName;
    private String sLastName;
    private String sId;
    private String courses;
    private int gradeYear;
    private int tuitionBalance;
    private static int courseFee = 600;    
    private static int ID = 1000;
    
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

    //View balance

    //Pay tuition
}
