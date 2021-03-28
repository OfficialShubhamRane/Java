package raneShubham;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

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
        primaryStage.getIcons().getClass().getClassLoader().getResource("University_image.png");
        primaryStage.setTitle("University Enrollment System");
        primaryStage.setScene(BasicInfoScene);
        primaryStage.show();

    }

}
