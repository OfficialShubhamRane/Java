package raneShubham;

import java.util.*;

public class NewStudent {

    private static String uuid;
    private static String fname;
    private static String mname;
    private static String lname;
    private static String emailAddress;
    private static String contactNo;
    private static String birthDate;
    private static String gender;
    private static String admittingIn;
    private static String academicTerm;

    private static List<String> subjectsSelected = new ArrayList<String>();
    private static int billGenerated;
    private static int amountPaid;
    private static int amountDue;

    public static void setUuid(String uuid) {
        NewStudent.uuid = uuid;
    }

    public static void setFname(String fname) {
        NewStudent.fname = fname;
    }

    public static void setMname(String mname) {
        NewStudent.mname = mname;
    }

    public static void setLname(String lname) {
        NewStudent.lname = lname;
    }

    public static void setEmailAddress(String emailAddress) {
        NewStudent.emailAddress = emailAddress;
    }

    public static void setContactNo(String contactNo) {
        NewStudent.contactNo = contactNo;
    }

    public static void setBirthDate(String birthDate) {
        NewStudent.birthDate = birthDate;
    }

    public static void setGender(String gender) {
        NewStudent.gender = gender;
    }

    public static void setAdmittingIn(String admittingIn) {
        NewStudent.admittingIn = admittingIn;
    }

    public static void setAcademicTerm(String academicTerm) {
        NewStudent.academicTerm = academicTerm;
    }

    public void setSubjectsSelected(List<String> subjectsSelected) {
        NewStudent.subjectsSelected = subjectsSelected;
    }

    public static String inString() {
        return "NewStudent{" +
                "uuid='" + uuid + '\'' +
                ", fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", admittingIn='" + admittingIn + '\'' +
                ", academicTerm='" + academicTerm + '\'' +
                ", subjectsSelected=" + subjectsSelected +
                ", billGenerated=" + billGenerated +
                ", amountPaid=" + amountPaid +
                ", amountDue=" + amountDue +
                '}';
    }

    public void setBillGenerated(int billGenerated) {
        NewStudent.billGenerated = billGenerated;
    }

    public void setAmountPaid(int amountPaid) {
        NewStudent.amountPaid = amountPaid;
    }

    public void setAmountDue(int amountDue) {
        NewStudent.amountDue = amountDue;
    }

    public static String getUuid() {
        return uuid;
    }

    public static String getFname() {
        return fname;
    }

    public static String getMname() {
        return mname;
    }

    public static String getLname() {
        return lname;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static String getContactNo() {
        return contactNo;
    }

    public static String getAdmittingIn() {
        return admittingIn;
    }

    public static String getAcademicTerm() {
        return academicTerm;
    }

    public static List<String> getSubjectsSelected() {
        return subjectsSelected;
    }

    public static int getBillGenerated() {
        return billGenerated;
    }

    public static int getAmountPaid() {
        return amountPaid;
    }

    public static int getAmountDue() {
        return amountDue;
    }

}
