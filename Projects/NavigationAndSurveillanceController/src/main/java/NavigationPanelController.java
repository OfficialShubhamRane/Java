import com.github.sarxos.webcam.Webcam;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class NavigationPanelController {

    public TextArea systemLogTA_ID;
    public Label opName_ID;
    public Button captureImageBtn_ID;
    public Button stopVideoBtn_ID;
    public Button startVideoBtn_ID;
    public MediaView mediaView_ID;


    public void initialize(){
        LoginController loginObj = new LoginController();
//        opName_ID.setText(loginObj.operatorName);
    }


    /**
     * Calculating for How long key was pressed
     * */
    KeyCode currKey;
    KeyCode lastKey = null;
    long keyPressedMillis = 0;
    long keyPressLength = 0;

    /** Time when key was pressed */
    public void arrowKeyStrokesHandler(KeyEvent keyEvent) {
        currKey = keyEvent.getCode();
        if(currKey != lastKey){
            lastKey = currKey;
            if(currKey == KeyCode.W){ //UP
                keyPressedMillis = System.currentTimeMillis();
            }
            else if(currKey == KeyCode.D){ //RIGHT
                keyPressedMillis = System.currentTimeMillis();
            }
            else if(currKey == KeyCode.A){ //LEFT
                keyPressedMillis = System.currentTimeMillis();
            }
            else if(currKey == KeyCode.S){ //DOWN/BACK
                keyPressedMillis = System.currentTimeMillis();
            }
            else if(currKey == KeyCode.SPACE){ // Stop/Space
                keyPressedMillis = System.currentTimeMillis();
            }
        }
    }

    /** System time - time when key was released */
    public void arrowKeyReleaseHandler(KeyEvent keyEvent) {

        KeyCode releasedKey = keyEvent.getCode();
        if (currKey == releasedKey) {
            keyPressLength = System.currentTimeMillis() - keyPressedMillis;
            keyPressedMillis = 0;
            lastKey = null;
        }


        /** Controls and SystemLogging on TextArea*/
        if (currKey == KeyCode.W) {

            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Forward : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
            }else{
                systemLogTA_ID.appendText("Forward : " + keyPressLength%1000 + " millisec");
            }
            systemLogTA_ID.appendText("\n");
        }
        else if (currKey == KeyCode.A){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Left        : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
            }else{
                systemLogTA_ID.appendText("Left        : " + keyPressLength%1000 + " millisec");
            }
            systemLogTA_ID.appendText("\n");
        }
        else if(currKey == KeyCode.S){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Reverse : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");

            }else{
                systemLogTA_ID.appendText("Reverse : " + keyPressLength%1000 + " millisec");
            }
            systemLogTA_ID.appendText("\n");
        }
        else if(currKey == KeyCode.D){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Right     : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
            }else{
                systemLogTA_ID.appendText("Right     : " + keyPressLength%1000 + " millisec");
            }
            systemLogTA_ID.appendText("\n");
        }
        else if(currKey == KeyCode.SPACE){
            systemLogTA_ID.appendText("Brake");
            systemLogTA_ID.appendText("\n");
        }

    }

    /** MediaView Video Controls */
    final String  Media_URL = "sample1.mp4";
    MediaPlayer media_player = new MediaPlayer(new Media(this.getClass().getResource(Media_URL).toExternalForm() ));

    /** Starts video in MediaView */
    public void startVideoBtnClicked(ActionEvent event) {
        media_player.setAutoPlay(true);
        mediaView_ID.setMediaPlayer(media_player);
    }
    /** Stops video in MediaView */
    public void stopVideoBtnClicked(ActionEvent event) {
        media_player.setAutoPlay(false);
    }

    /** Capture Image from Video Cam */
    boolean isCameraOpen = false;
    Webcam webCamObj = Webcam.getDefault();
    public void captureImageBtnClicked(ActionEvent event) throws IOException {
        webCamObj.open();
        ImageIO.write(webCamObj.getImage(), "JPG", new File("src/main/firstCapture.jpg"));
        webCamObj.close();
    }
}
