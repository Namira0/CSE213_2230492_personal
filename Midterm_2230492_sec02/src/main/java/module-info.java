module com.example.midterm_2230492_sec02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.midterm_2230492_sec02 to javafx.fxml;
    exports com.example.midterm_2230492_sec02;
}