module com.shubham.rane.FXwithMaven {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.shubham.rane.FXwithMaven to javafx.fxml;
    exports com.shubham.rane.FXwithMaven;
}