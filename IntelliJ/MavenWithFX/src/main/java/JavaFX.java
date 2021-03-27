import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class JavaFX extends Application {

    public static void main(String[] args) {

        System.out.println("Hello");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World!");

        FXMLLoader loader = new FXMLLoader();
        FileInputStream fxmlStream = new FileInputStream("src/main/resources/FXMLexample.fxml");
        StackPane root = loader.load(fxmlStream);

//        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
