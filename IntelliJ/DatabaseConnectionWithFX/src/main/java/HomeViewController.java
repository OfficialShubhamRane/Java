import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.embed.swing.SwingFXUtils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.sql.*;

public class HomeViewController {

    @FXML
    public Button camStartButton_ID1;
    public Pane webCamFeed_ID;

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

    Mat matrix = new Mat();


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

    Webcam webCamObj = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webCamObj);
    public void camStartButtonClicked() {
        webCamFeed_ID = new Pane();
        SwingNode swingNode = new SwingNode();
        createContentPane(swingNode);
        webCamFeed_ID.getChildren().add(swingNode);
    }
    public void createContentPane(SwingNode swingNode){
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(webcamPanel);
            }
        };
        SwingUtilities.invokeLater(runner);
    }


    /**
     * Detect Face from Image
     * */

    public void ImageFaceDetectBtnClicked(ActionEvent event) throws SQLException {


        //Reading the Image from the file
//        Mat matrix = Imgcodecs.imread("E:/Java/IntelliJ/DatabaseConnectionWithFX/src/main/Random1.jpg");
//        System.out.println("Image Loaded");
//
//        Imgcodecs.imwrite("E:/Java/IntelliJ/DatabaseConnectionWithFX/src/main/Random2.jpg", matrix);
//        System.out.println("Image Copied");

        //Face detection
        capureSnapShot();

    }

    public void capureSnapShot() {

        VideoCapture cap = new VideoCapture(0);
        cap.read(matrix);
        if(!matrix.empty()){
            System.out.println("Read successfully");
        }

//        WritableImage WritableImage = null;
//        VideoCapture capture = new VideoCapture(0);
//
//        // Reading the next video frame from the camera
//
//        capture.read(matrix);
//
//        // If camera is opened
//        if( capture.isOpened()) {
//            // If there is next video frame
//            if (capture.read(matrix)) {
//                // Creating BuffredImage from the matrix
//                BufferedImage image = new BufferedImage(matrix.width(),
//                        matrix.height(), BufferedImage.TYPE_3BYTE_BGR);
//
//                WritableRaster raster = image.getRaster();
//                DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
//                byte[] data = dataBuffer.getData();
//                matrix.get(0, 0, data);
//
//                // Creating the Writable Image
//                WritableImage = SwingFXUtils.toFXImage(image, null);
//            }
//        }
    }

}
