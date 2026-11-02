module com.example.autumn24_practice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.autumn24_practice to javafx.fxml;
    exports com.example.autumn24_practice;
}