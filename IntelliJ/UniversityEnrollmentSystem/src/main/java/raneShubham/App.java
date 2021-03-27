package raneShubham;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class App extends Application {

    public static void main(String[] args ) {

        System.out.println("Entered in main");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Entered in start");
        Parent BasicInfo = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AddStudent.fxml")));
        Scene BasicInfoScene = new Scene(BasicInfo);
        primaryStage.setScene(BasicInfoScene);
        primaryStage.show();



    }

}
