module com.example.ejemploahorcado {
    requires javafx.controls;
    requires javafx.fxml;
    requires datafaker;
    requires java.logging;


    opens com.example.ejemploahorcado to javafx.fxml;
    exports com.example.ejemploahorcado;
}