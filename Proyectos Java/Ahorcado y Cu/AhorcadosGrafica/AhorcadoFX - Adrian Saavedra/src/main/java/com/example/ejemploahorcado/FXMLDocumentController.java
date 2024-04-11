package com.example.ejemploahorcado;

import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.domain.Juego;
import com.example.ejemploahorcado.service.GestionPalabras;
import com.example.ejemploahorcado.ui.GestionJuego;
import com.example.ejemploahorcado.ui.PruebaTotal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane mainGrid;
    @FXML
    private Label palabra;
    @FXML
    private Label fallos;
    @FXML
    private Label saludo;
    private Juego juego;

    @FXML
    private Button botonSalir;
    @FXML
    private Button boton;
    @FXML
    private ImageView imagen;
    private int estado;  //fallos
    private String adivinar; //en este label podemos ir poniendo ____ y destapando
    private GestionPalabras gestionPalabras; //lo vuelvo global

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestionPalabras = new GestionPalabras();
        iniciarDesdeCero();
    }
    private void iniciarDesdeCero() {
        juego = GestionJuego.juego(gestionPalabras);
        mostrarTablero();
        saludo.setText(juego.pintarpalabraChar().toString());
        fallos.setText("Fallos: " + juego.getFallos() + "/7 " + juego.pintarFallidas());
        imagen.setImage(new Image("File:src/main/resources/com/example/ejemploahorcado/images/" + juego.getFallos() + ".png"));
    }


    private void mostrarTablero() {
        Pane pane;
        char caracter = 'A';
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 7; j++, caracter++) {
                pane = new Pane();
                if (i * 8 + j < 26) {
                    if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                        pane.setStyle("-fx-background-color: #07004f;");
                    } else {
                        pane.setStyle("-fx-background-color: #56e15c");
                    }
                    Label letra = new Label(String.valueOf(caracter));
                    letra.setTextFill(Color.web("#ffffff"));
                    //letra.setTextFill(Color.WHITE);
                    pane.getChildren().addAll(letra);
                    letra.layoutXProperty().bind(pane.widthProperty().subtract(letra.widthProperty()).divide(3));
                    letra.layoutYProperty().bind(pane.heightProperty().subtract(letra.heightProperty()).divide(3));
                    mainGrid.add(pane, j, i);
                    String message = "Click on cell [" + i + ", " + j + "]";
                    int fila = i;
                    int columna = j;
                    pane.setOnMouseClicked(e -> {
                        System.out.println(message);
                        accion(fila, columna);
                    });

                }
            }
        }
    }

    private void accion(int fila, int columna) {
        saludo.setText(juego.pintarpalabraChar().toString());
        if (juego.fin() == 0) {
            int posicion_pulsada = fila * 8 + columna + 65;
            String letra_pulsada = String.valueOf((char) posicion_pulsada);
            String jugada = juego.jugada(letra_pulsada.charAt(0));
            System.out.println("Letra pulsada:  " + letra_pulsada);
            if (jugada == null) {
                saludo.setText(juego.pintarpalabraChar().toString());
                palabra.setText(Constantes.INGRESA_LA_PALABRA_A_ADIVINAR);
            } else {
                palabra.setText(jugada);
                fallos.setText("Fallos: " + juego.getFallos() + "/7 -> ("+juego.pintarFallidas()+")");
                imagen.setImage(new Image("File:src/main/resources/com/example/ejemploahorcado/images/" + juego.getFallos() + ".png"));
            }
        }
        if (juego.fin() == 1) {
            palabra.setText("GAME OVER. "+Constantes.ESTA_ERA_LA_PALABRA_QUE_TENIAS_QUE_ADIVINAR +"\n"+juego.getaAdivinar().getIncognita()+"\n");
        } else if (juego.fin() == 2) {
            palabra.setText(Constantes.ENHORABUENA_LO_HAS_LOGRADO + " " + juego.getJugador().getNombre());

        }

    }

    @FXML
    private void guardarPartida(ActionEvent actionEvent) {
        gestionPalabras.escribirFicheroBinario(juego);
    }

    @FXML
    private void reiniciarPartida(ActionEvent actionEvent) {
        iniciarDesdeCero();
    }

    @FXML
    private void salirPartida(ActionEvent actionEvent) {
        Stage stage = (Stage) botonSalir.getScene().getWindow();
        stage.close();
    }


}
