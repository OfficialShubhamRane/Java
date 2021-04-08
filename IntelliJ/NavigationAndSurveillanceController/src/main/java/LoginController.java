import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    @FXML
    public AnchorPane rootPane;
    public static String operatorName;

    @FXML
    private PasswordField passwordTf_ID;

    @FXML
    private TextField userIDTf_ID;

    public boolean isValidUser;

    @FXML
    void loginBtnClicked(ActionEvent event) throws SQLException, IOException {
        System.out.println("User_ID: " + userIDTf_ID.getText());
        System.out.println("Password: " + passwordTf_ID.getText());
        operatorName = userIDTf_ID.getText();

        isValidUser = LoginDAO.authenticateUser(userIDTf_ID.getText(),passwordTf_ID.getText());

        Pane navigationPanel = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("NavigationPanelView.fxml")));
        // set height and width here for this login scene
        Scene scene = new Scene(navigationPanel, 1000, 800);
        rootPane.setPrefHeight(440);
        rootPane.setPrefWidth(840);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
    }

}
