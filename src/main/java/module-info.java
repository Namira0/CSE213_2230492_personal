module com.example.mockmid_practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.mockmid_practice to javafx.fxml;
    exports com.example.mockmid_practice;
}