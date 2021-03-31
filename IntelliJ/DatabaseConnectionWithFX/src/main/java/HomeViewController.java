import com.github.sarxos.webcam.Webcam;

import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class HomeViewController {

    @FXML
    public Pane paneView_ID;

    @FXML
    private MediaView mediaView_ID;

    @FXML
    private Button camStartButton_ID;

    @FXML
    private TextField textBox_ID;

    @FXML
    private TextArea textArea_ID;

    @FXML
    private Label label_ID;

    String URL = "jdbc:mysql://127.0.0.1:3306/neon?autoreconnect=true";
    String PASSWORD = "1234";
    String USERNAME = "root";

    Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    Statement stmt = con.createStatement();


    //constructor to handle exception thrown by Connection and statement
    public HomeViewController() throws SQLException {
    }

    /**
     * Sending data to database table
     * */
    public void sendBtnClicked(ActionEvent event) throws SQLException {

        System.out.println("Received: " + textBox_ID.getText());
        String setSQL = "INSERT into neon.student (rollNo, name) VALUES (?,?)";
        PreparedStatement prpdStmt = con.prepareStatement(setSQL);
        prpdStmt.setInt(1,4);
        prpdStmt.setString(2,textBox_ID.getText());
        prpdStmt.executeUpdate();
    }

    /**
     * Retriving data from database
     * */
    public void getDataClicked(ActionEvent event) throws SQLException {

        String getSQL = "SELECT * from neon.student";
        ResultSet rs = stmt.executeQuery(getSQL);

        while(rs.next()){
            System.out.println(rs.getString("name"));
            textArea_ID.appendText(rs.getString("name"));
            textArea_ID.appendText("\n");
        }

    }

    /**
    * Chaning data/label value on screen when key was pressed
    * */
    public void changeLabelKeyInpute(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            System.out.println("Enter pressed");
            label_ID.setText("ENTER");
        }
        if(keyEvent.getCode() == KeyCode.SPACE){
            System.out.println("Space pressed");
            label_ID.setText("SPACE");
        }
    }

    /**
     * Calculating for How long key was pressed
     * */
    KeyCode currKey;
    KeyCode lastKey = null;
    long keyPressedMillis = 0;
    long keyPressLength = 0;
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

        }
    }   // time when key was pressed
    public void arrowKeyReleaseHandler(KeyEvent keyEvent) {

        KeyCode releasedKey = keyEvent.getCode();
        if(currKey == releasedKey){
            keyPressLength = System.currentTimeMillis() - keyPressedMillis;
            keyPressedMillis = 0;
            lastKey = null;
        }
        System.out.println(currKey +": " + keyPressLength);
    }   // System time - time when key was released

    /**
     * Capturing image/video from webcam
     * */
    public void vidStartButtonClicked(ActionEvent event) {
        final String  Media_URL = "sample1.mp4";
        System.out.println( this.getClass().getResource(Media_URL).toExternalForm() );
        MediaPlayer media_player = new MediaPlayer(new Media(this.getClass().getResource(Media_URL).toExternalForm() ));
        media_player.setAutoPlay(true);
        mediaView_ID.setMediaPlayer(media_player);
    }

    public void camStartButtonClicked(ActionEvent event) throws IOException {
        Webcam webCamObj = Webcam.getDefault();
        webCamObj.open();
//        webCamObj.setViewSize(WebcamResolution.VGA.getSize());

//        WebcamPanel webcamPanelObj = new WebcamPanel(webCamObj);
        ImageIO.write(webCamObj.getImage(), "JPG", new File("firstCapture.jpg"));


    }
}
