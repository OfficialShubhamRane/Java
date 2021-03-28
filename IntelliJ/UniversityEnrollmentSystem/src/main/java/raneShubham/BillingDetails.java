package raneShubham;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BillingDetails {

    @FXML
    private Label billingName;

    @FXML
    private Label billingEmail;

    @FXML
    private Label billingAdmittingAs;

    @FXML
    private Label billingAdmittingTerm;

    @FXML
    private Label generatedBill;

    @FXML
    private void initialize(){
        System.out.println("Entered in billing details iniitalize");
        billingName.setText(NewStudent.getFname() + " " + NewStudent.getMname() + " " + NewStudent.getLname());
        billingEmail.setText(NewStudent.getEmailAddress());
        billingAdmittingAs.setText(NewStudent.getAdmittingIn());
        billingAdmittingTerm.setText(NewStudent.getAcademicTerm());
        generatedBill.setText("$21,000");
    }
}
