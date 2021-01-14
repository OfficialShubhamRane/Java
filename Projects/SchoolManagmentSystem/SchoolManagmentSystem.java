/**
 * SchoolManagmentSystem
 */
import java.util.Scanner;
public class SchoolManagmentSystem {

    public static void main(String[] args) {

        System.out.println("Enter no. of students want to add: ");
        Scanner sc = new Scanner(System.in);
        int numOfStuds = sc.nextInt();

        Students[] students = new Students[numOfStuds];
        
        for (int i=0; i<numOfStuds; i++) {
            System.out.println("#############################################################");
            students[i] = new Students();
            students[i].enrollCourses();
            students[i].payTution();
        }
        
        int totalStuds = students.length;
        for (int i=0; i<totalStuds; i++) {
            System.out.println("************************************************************");
            System.out.println();
            students[i].viewInfo();
        }









    }
}