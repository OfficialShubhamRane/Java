import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.sql.*;

public class HomeViewController {

    @FXML
    private TextField textBox_ID;

    @FXML
    private TextArea textArea_ID;

    @FXML
    private Button getData_ID;

    @FXML
    private Label label_ID;

    String url = "jdbc:mysql://127.0.0.1:3306/neon?autoreconnect=true";
    String password = "1234";
    String username = "root";

    Connection con = DriverManager.getConnection(url, username, password);
    Statement stmt = con.createStatement();

    //constructor to handle exception thrown by Connection and statement
    public HomeViewController() throws SQLException {
    }

    public void sendBtnClicked(ActionEvent event) throws SQLException {

        System.out.println("Received: " + textBox_ID.getText());
        String setSQL = "INSERT into neon.student (rollNo, name) VALUES (?,?)";
        PreparedStatement prpdStmt = con.prepareStatement(setSQL);
        prpdStmt.setInt(1,4);
        prpdStmt.setString(2,textBox_ID.getText());
        prpdStmt.executeUpdate();
    }

    public void getDataClicked(ActionEvent event) throws SQLException {

        String getSQL = "SELECT * from neon.student";
        ResultSet rs = stmt.executeQuery(getSQL);

        while(rs.next()){
            System.out.println(rs.getString("name"));
            textArea_ID.appendText(rs.getString("name"));
            textArea_ID.appendText("\n");
        }

    }

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
            if(currKey == KeyCode.D){ //RIGHT
                keyPressedMillis = System.currentTimeMillis();
            }
            if(currKey == KeyCode.A){ //LEFT
                keyPressedMillis = System.currentTimeMillis();
            }
            if(currKey == KeyCode.S){ //DOWN/BACK
                keyPressedMillis = System.currentTimeMillis();
            }
        }
    }

    public void arrowKeyReleaseHandler(KeyEvent keyEvent) {

        KeyCode releasedKey = keyEvent.getCode();
        if(currKey == releasedKey){
            keyPressLength = System.currentTimeMillis() - keyPressedMillis;
            keyPressedMillis = 0;
            lastKey = null;
        }
        System.out.println(currKey +": " + keyPressLength);
    }
}
