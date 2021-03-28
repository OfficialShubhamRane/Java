package raneShubham;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BasicDetails{

    @FXML
    private TextField fname;

    @FXML
    private TextField mname;

    @FXML
    private TextField lname;

    @FXML
    private RadioButton gender_male;

    @FXML
    private ToggleGroup gendrer;

    @FXML
    private RadioButton gender_female;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField emailAddress;

    @FXML
    public void initialize(){
        gendrer.selectToggle(gender_male);
    }

    /** Fetches data from all data fields */
    @FXML
    void btnSubmitClicked(ActionEvent event) throws IOException {

        /**
         * Fetching and setting values of from Basic Details scene
         * */

        NewStudent.setFname(fname.getText());
        NewStudent.setMname(mname.getText());
        NewStudent.setLname(lname.getText());
        if(gender_male.isSelected()){
            NewStudent.setGender("male");
        }else if(gender_female.isSelected()){
            NewStudent.setGender("female");
        }
        NewStudent.setEmailAddress(emailAddress.getText());
        NewStudent.setBirthDate(birthDate.getEditor().getText());

        /**
         * Travelling to EnrollmentDetail scene
         * */
        Parent EnrollmentDetails = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("EnrollmentDetails.fxml")));
        Scene EnrollmentDetailsScene = new Scene(EnrollmentDetails);
        Stage EnrollmentDetailsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        EnrollmentDetailsStage.setScene(EnrollmentDetailsScene);

        System.out.println(NewStudent.inString());
    }

    /** Resets all the in Basic info Scene fields */
    @FXML
    void btnResetAll(ActionEvent event){
        fname.setText("");
        mname.setText("");
        lname.setText("");
        gender_male.setSelected(false);
        gender_female.setSelected(false);
        birthDate.setValue(null);
        emailAddress.setText("");
    }


}
