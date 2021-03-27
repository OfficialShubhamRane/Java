package raneShubham;

import javafx.application.Application;
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


    /** Fetches data from all data fields */
    @FXML
    void btnSubmitClicked(ActionEvent event) throws IOException {
//        System.out.println(fname.getText() + " " + mname.getText() + " " + lname.getText());
//        System.out.println("birthDate: " +  ((TextField)birthDate.getEditor()).getText()  );
//        System.out.println("male: " + gender_male.isSelected() );
//        System.out.println("female: " + gender_female.isSelected() );
//        System.out.println("email: " + emailAddress.getText());

        Parent EnrollmentDetails = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("EnrollmentDetails.fxml")));
        Scene EnrollmentDetailsScene = new Scene(EnrollmentDetails);
        Stage EnrollmentDetailsStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        EnrollmentDetailsStage.setScene(EnrollmentDetailsScene);

    }

    /** Resets all the fields */
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
