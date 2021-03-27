package raneShubham;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;


public class EnrollmentDetails{

    @FXML
    private ToggleGroup rdAdmissionYear;

    @FXML
    private ChoiceBox<String> termMonthChoiceBox;

    @FXML
    private ChoiceBox<String> termYearChoiceBox;

    @FXML
    private void initialize(){
            termMonthChoiceBox.getItems().addAll("Spring","Summer","Fall");
            termYearChoiceBox.getItems().addAll("2021","2022","2023");
    }

}