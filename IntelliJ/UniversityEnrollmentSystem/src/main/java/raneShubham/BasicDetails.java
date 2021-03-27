package raneShubham;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BasicDetails {

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
    private Button btnResetAll;

    @FXML
    private Button btnSubmit;

    @FXML
    void btnSubmitClicked(ActionEvent event) {
        System.out.println(fname.getText() + " " + mname.getText() + " " + lname.getText());
        System.out.println("birthDate: " + birthDate.toString() );
        System.out.println("Submit button " + btnSubmit.toString() );
        System.out.println("Gender " + gendrer.toString());
        System.out.println("male " + gender_male.toString());
        System.out.println("female " + gender_female.toString());
        System.out.println("email " + emailAddress.getText());
    }

}
