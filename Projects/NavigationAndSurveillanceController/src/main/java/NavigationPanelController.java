
/** Author: Shubham Rane www.linkedin.com/in/shubham-rane97 **/

import com.github.sarxos.webcam.Webcam;
import com.sun.jdi.InvocationException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class NavigationPanelController {

    public TextArea systemLogTA_ID;
    public TextField opName_ID;
    public Button captureImageBtn_ID;
    public Button startVideoBtn_ID;
    public MediaView mediaView_ID;
    public TextField batteryLife_ID;
    public TextField distaceCovered_ID;
    public Button forwardBtn_ID;


    public void initialize(){
        /** Sets operator name fetching from user_ID field from login */
        opName_ID.setText(LoginController.operatorName);

        /** Battery of laptop showing here can be replaced with vehicles battery */
        Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
        Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
        batteryLife_ID.setText(batteryStatus.toString());
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
    StringBuilder backTrackingLog = new StringBuilder();
    public void arrowKeyReleaseHandler(KeyEvent keyEvent) throws IOException, InvocationException {

        KeyCode releasedKey = keyEvent.getCode();
        if (currKey == releasedKey) {
            keyPressLength = System.currentTimeMillis() - keyPressedMillis;
            keyPressedMillis = 0;
            lastKey = null;
        }

        /** Values for heatmap */
        String direction = null;
        long distance = 0;

        /** Controls and SystemLogging on TextArea */
        if (currKey == KeyCode.W) {

            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Forward : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
                timeTravelled += keyPressLength;
                totalDistanceTravelled();

                backTrackingLog.append("Reverse : ").append(keyPressLength / 1000).append(" sec ");
                backTrackingLog.append(keyPressLength % 1000).append(" millisec");

                direction = "Forward";
                distance = keyPressLength/1000;

            }else{
                systemLogTA_ID.appendText("Forward : " + keyPressLength%1000 + " millisec");
                backTrackingLog.append("Reverse : ").append(keyPressLength % 1000).append(" millisec");
            }
            systemLogTA_ID.appendText("\n");
            backTrackingLog.append("\n");

        }
        else if (currKey == KeyCode.A){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Left        : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
                timeTravelled += keyPressLength;
                totalDistanceTravelled();

                backTrackingLog.append("Right      : ").append(keyPressLength / 1000).append(" sec ");
                backTrackingLog.append(keyPressLength % 1000).append(" millisec");

                direction = "Left";
                distance = keyPressLength/1000;

            }else{
                systemLogTA_ID.appendText("Left        : " + keyPressLength%1000 + " millisec");
                backTrackingLog.append("Right      : ").append(keyPressLength % 1000).append(" millisec");
            }
            systemLogTA_ID.appendText("\n");
            backTrackingLog.append("\n");
            totalDistanceTravelled();

        }
        else if(currKey == KeyCode.S){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Reverse : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
                timeTravelled += keyPressLength;
                totalDistanceTravelled();

                backTrackingLog.append("Forward : ").append(keyPressLength / 1000).append(" sec ");
                backTrackingLog.append(keyPressLength % 1000).append(" millisec");


                direction = "Reverse";
                distance = keyPressLength/1000;

            }else{
                systemLogTA_ID.appendText("Reverse : " + keyPressLength%1000 + " millisec");
                backTrackingLog.append("Forward : ").append(keyPressLength % 1000).append(" millisec");
            }
            systemLogTA_ID.appendText("\n");
            backTrackingLog.append("\n");
            totalDistanceTravelled();
        }
        else if(currKey == KeyCode.D){
            if(keyPressLength/1000 > 0){
                systemLogTA_ID.appendText("Right     : " + keyPressLength/1000 + " sec ");
                systemLogTA_ID.appendText(keyPressLength%1000 + " millisec");
                timeTravelled += keyPressLength;
                totalDistanceTravelled();

                backTrackingLog.append("Left       : ").append(keyPressLength / 1000).append(" sec ");
                backTrackingLog.append(keyPressLength % 1000).append(" millisec");

                direction = "Right";
                distance = keyPressLength/1000;


            }else{
                systemLogTA_ID.appendText("Right     : " + keyPressLength%1000 + " millisec");
                backTrackingLog.append("Left       : ").append(keyPressLength % 1000).append(" millisec");
            }
            systemLogTA_ID.appendText("\n");
            backTrackingLog.append("\n");

        }
        else if(currKey == KeyCode.SPACE){
            systemLogTA_ID.appendText("Brake");
            systemLogTA_ID.appendText("\n");

            backTrackingLog.append("Brake");
            backTrackingLog.append("\n");
        }

        /** Sending data tto heatMapGenerator class after each key release*/
        assert direction != null;
        HeatMapGenerator.heatChartGenerator(direction, distance);
        HeatMapGenerator.heatMapGeneration();

        /** Periodically check for battery status after each key release*/
        batteryStatusChecker();

    }

    /** Total distance travelled */
    float timeTravelled = 0;
    float coveredDistance = 0;
    public void totalDistanceTravelled(){
        System.out.println(timeTravelled);
        coveredDistance = (float) ((5.0 / 360.0) * timeTravelled);
        distaceCovered_ID.setText(String.valueOf(coveredDistance));
    }

    /** Backtrack logs */
    public void backtrackBtnClicked(ActionEvent event) {
        systemLogTA_ID.setText(String.valueOf(backTrackingLog));
    }

    /** Battery of laptop/vehicle displayed here */
    public void batteryStatusChecker(){
        Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
        Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
        batteryLife_ID.setText(batteryStatus.toString());
    }

    /** MediaView Video Controls - Play-Pause video in MediaView */
    private boolean isPaused = true;
    final String  Media_URL = "sample1.mp4";
    MediaPlayer media_player = new MediaPlayer(new Media(Objects.requireNonNull(this.getClass().getResource(Media_URL)).toExternalForm() ));
    public void startVideoBtnClicked(ActionEvent event) {

        if (isPaused){
            media_player.play();
            mediaView_ID.setMediaPlayer(media_player);
            isPaused = false;
        }else{
            media_player.pause();
            isPaused = true;
        }
    }

    /** Capture multiple Image from default camera */
    private int pictureID = 1;
    public void captureImageBtnClicked(ActionEvent event) throws IOException {
        Webcam webCamObj = Webcam.getDefault();
        webCamObj.open();

        String fileNameCreator = "src/main/"+pictureID+"_Capture.jpg";
        ImageIO.write(webCamObj.getImage(), "JPG", new File(fileNameCreator));
        pictureID++;
        webCamObj.close();
    }

}
