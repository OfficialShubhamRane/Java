import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        float temp = (float) (((5.0/360.0) * 10.0) / 0.00062137);
        System.out.println(temp);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent LoginView = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("LoginView.fxml")));
        Scene LoginViewScene = new Scene(LoginView);
        primaryStage.setScene(LoginViewScene);
        primaryStage.setTitle("Navigation&Surveillance Controller");
        primaryStage.show();

    }
}
