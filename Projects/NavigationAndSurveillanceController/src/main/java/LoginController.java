import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    @FXML
    public AnchorPane rootPane;
    public String operatorName;

    @FXML
    private PasswordField passwordTf_ID;

    @FXML
    private TextField userIDTf_ID;

    public boolean isValidUser;

    @FXML
    void loginBtnClicked(ActionEvent event) throws SQLException, IOException {
        System.out.println("User_ID: " + userIDTf_ID.getText());
        System.out.println("Password: " + passwordTf_ID.getText());
        isValidUser = LoginDAO.authenticateUser(userIDTf_ID.getText(),passwordTf_ID.getText());
        System.out.println(isValidUser);

        Pane navigationPanel = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("NavigationPanelView.fxml")));
        rootPane.setPrefHeight(440);
        rootPane.setPrefWidth(840);
        rootPane.getChildren().setAll(navigationPanel);
    }

}
