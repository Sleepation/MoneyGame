module org.example.moneygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ui to javafx.fxml;
    exports org.example.ui;
    exports org.example;
    opens org.example to javafx.fxml;
    exports org.example.buttons;
    opens org.example.buttons to javafx.fxml;
    exports org.example.info;
    opens org.example.info to javafx.fxml;
}