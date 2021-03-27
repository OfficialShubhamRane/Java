package rane.Shubham.UniversityEnrollmentSystem;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application{
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("Entered in start");
		Parent root = FXMLLoader.load(getClass().getResource("/UniversityEnrollmentSystem/src/main/java/fxml/AddStudent.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
