module com.example.ejemplosconcurrenciag3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ejemplosconcurrenciag3 to javafx.fxml;
    exports com.example.ejemplosconcurrenciag3;
}