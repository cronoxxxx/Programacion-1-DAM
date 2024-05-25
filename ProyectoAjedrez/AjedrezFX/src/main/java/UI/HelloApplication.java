package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(Locale.ROOT);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mensajes"); //Para los properties
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"), resourceBundle);
        Scene scene = new Scene(root,500,700);
        stage.setTitle("Ajedrez de Adrian");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}