package raneShubham;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.util.Objects;

public class App extends Application
{

    public static void main(String[] args ) {

        System.out.println("Entered in main");
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Entered in start");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("AddStudent.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
