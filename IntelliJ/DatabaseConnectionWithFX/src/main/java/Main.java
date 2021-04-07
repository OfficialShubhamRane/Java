import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencv.core.Core;

import java.util.Objects;

public class Main extends Application{


    @Override
    public void start(Stage stage) throws Exception {

        Parent HomeView = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("HomeView.fxml")));
        Scene HomeViewScene = new Scene(HomeView);
        stage.setScene(HomeViewScene);
        stage.setTitle("Home");
        stage.show();

    }

    public static void main(String[] args){
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        launch(args);

    }

}
