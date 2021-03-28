package raneShubham;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EnrollmentDetails {

    @FXML
    private RadioButton freshman;

    @FXML
    private ToggleGroup rdAdmissionYear;

    @FXML
    private RadioButton junior;

    @FXML
    private RadioButton senior;

    @FXML
    private RadioButton sophmore;

    @FXML
    private ChoiceBox<String> termMonthChoiceBox;

    @FXML
    private ChoiceBox<String> termYearChoiceBox;

    @FXML
    private Button enrollmentSubmit;

    @FXML
    private Button enrollment_basic;

    @FXML
    private void initialize(){
        termMonthChoiceBox.getItems().addAll("Spring","Summer","Fall");
        termYearChoiceBox.getItems().addAll("2021","2022","2023");
    }

    @FXML
    public void btnEnrollmentClicked(ActionEvent event) throws IOException {
        System.out.println("Enrollment Submit clicked");


        if (freshman.isSelected()){
            NewStudent.setAdmittingIn("freshman");
        }else if(sophmore.isSelected()){
            NewStudent.setAdmittingIn("sophmore");
        }else if(junior.isSelected()){
            NewStudent.setAdmittingIn("junior");
        }else if(senior.isSelected()){
            NewStudent.setAdmittingIn("senior");
        }

        NewStudent.setAcademicTerm(termMonthChoiceBox.getValue().concat(" " + termYearChoiceBox.getValue()));

        Parent BillingDetails = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("BillingDetails.fxml")));
        Scene BillingDetailsScene = new Scene(BillingDetails);
        Stage BillingDetailsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        BillingDetailsStage.setScene(BillingDetailsScene);

        System.out.println(NewStudent.inString());
    }

    @FXML
    public void btnEnrollment_BasicClicked(ActionEvent event) throws IOException {
        System.out.println("Going back to Basic Info from Enrollment Details");

        Parent BasicDetails = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AddStudent.fxml")));
        Scene BasicDetailsScene = new Scene(BasicDetails);
        Stage BasicDetailsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        BasicDetailsStage.setScene(BasicDetailsScene);
    }
}


