package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField doubleHeight;
    public TextField doubleWeight;
    public Label result;

    public void sayHello(){
        int resultInt = Integer.parseInt(doubleHeight.getText()) * Integer.parseInt(doubleWeight.getText());
        result.setText(String.valueOf(resultInt));
        }


}
