package UI;

import Modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import Principales.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Locale;

public class HelloController implements Initializable {
    @FXML
    private Label label2;
    @FXML
    public Button boton;
    @FXML
    private Label label;
    @FXML
    private GridPane mainGrid;

    private Tablero tablero;

    private Juego juego;
    private Posicion posorigen = null;
    private boolean fin;
    ResourceBundle resourceBundle;


    public HelloController() {
    }

    private StringProperty buttonText = new SimpleStringProperty("Português");

    public String getButtonText() {
        return buttonText.get();
    }

    public void setButtonText(String buttonText) {
        this.buttonText.set(buttonText);
    }

    public void initializeLanguageButton() {
        boton.textProperty().bind(buttonText); //vincula el texto de button al boton
    }
//carga el idioma con dos mensajes de bienvenida cada vez que presionas el boton
    private void loadLanguage(String lang) {
        resourceBundle = ResourceBundle.getBundle("mensajes", new Locale(lang));
        label.setText(resourceBundle.getString("TURNO_DE_BLANCAS"));
        label2.setText(resourceBundle.getString("BIENVENIDO"));
        setButtonText(lang);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle2) {
        // Creación de instancias de juego y tablero
        juego = new Juego();
        tablero = new Tablero();
        // Inicialización de variables (bandera para determinar si termino el juego en el metodo de click)
        fin = false;
        // Actualización visual del tablero
        pintarTablero();
        // Almacena la referencia al ResourceBundle proporcionado como parámetro a otros properties de otros idiomas
        resourceBundle = resourceBundle2;
        // Configura el texto de las etiquetas utilizando el ResourceBundle cargando el idioma
        label.setText(resourceBundle.getString("TURNO_DE_BLANCAS"));
        label2.setText(resourceBundle.getString("BIENVENIDO"));
        // Inicializa el botón de idioma
        initializeLanguageButton();
    }


    public void pintarTablero() {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    //pane.setStyle("-fx-background-color: #684714;");
                    pane.setStyle("-fx-background-color: #769853;");
                    //pane.setStyle("-fx-background-color: #2F2B2B;");
                } else {
                    //pane.setStyle("-fx-background-color: #ffe68e");
                    //pane.setStyle("-fx-background-color: #FF0000");
                    pane.setStyle("-fx-background-color: #e7ebca;");
                }
                if (tablero.hayPieza(i, j)) {
                    pane.getChildren().addAll(new ImageView(tablero.devuelvePieza(i, j).toImage()));
                }
                mainGrid.add(pane, j, i);
            }
        }
    }

    // Este método devuelve un array de Posicion que representa las posiciones válidas a las que se puede mover una pieza en la posición dada.
    public Posicion[] movimientosValidosFx(Posicion posicion) {
        // Se crea un array para almacenar las posiciones válidas.
        Posicion[] posiciones = new Posicion[20];
        // Contador para realizar un seguimiento de las posiciones válidas encontradas.
        int cont = 0;

        // Se verifica si hay una pieza en la posición dada.
        if (tablero.hayPieza(posicion.getFila(), posicion.getColumna())) {
            // Se verifica si la pieza pertenece al jugador en turno.
            if ((tablero.colorPieza(posicion.getFila(), posicion.getColumna()).equals("blanco") && juego.getTurno().equals("B"))
                    || (tablero.colorPieza(posicion.getFila(), posicion.getColumna()).equals("negro") && juego.getTurno().equals("N"))) {
                // Bucle para recorrer todas las posibles posiciones en el tablero.
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        // Se crea una posición de destino posible.
                        Posicion posfin = new Posicion(i, j);
                        // Se verifica si el movimiento es válido utilizando el método validadMovimiento.
                        if (juego.validadMovimiento(tablero, posicion, posfin, juego)) {
                            // Si el movimiento es válido, se agrega la posición al array y se incrementa el contador.
                            posiciones[cont] = new Posicion(i, j);
                            cont++;
                        }
                    }
                }
                // Si no se encontraron posiciones válidas, se muestra un mensaje.
                if (cont == 0) {
                    label2.setText(resourceBundle.getString("NO_PUEDE_MOVER_ESTA_PIEZA_A_NINGUNA_POSICIÓN"));
                }
            } else {
                // Si la pieza no pertenece al jugador en turno, se muestra un mensaje.
                label2.setText(resourceBundle.getString("NO_PUEDES_MOVER_UNA_PIEZA_QUE_NO_ES_TUYA"));
            }
        } else {
            // Si no hay una pieza en la posición dada, se muestra un mensaje.
            label2.setText(resourceBundle.getString("NO_HAY_PIEZA_EN_LA_POSICIÓN_INTRODUCIDA"));
        }
        // Devuelve el array de posiciones válidas.
        return posiciones;
    }

    // Este método valida la posición final de un movimiento y devuelve un objeto Movimiento si es válido.
    public Movimiento validarPosFinalFx(Posicion posfinal, Posicion posorigen) {
        // Se crea un objeto Movimiento con las posiciones de origen y destino.
        Movimiento mov = new Movimiento(posorigen, posfinal);
        // Se utiliza el método validadMovimientoFx para verificar si el movimiento es válido.
        String valido = juego.validadMovimientoFx(posorigen, posfinal, this.tablero, this.juego);
        // Si el movimiento no es válido, se asigna null al objeto Movimiento y se muestra un mensaje.
        if (valido != null) {
            mov = null;
            label2.setText(resourceBundle.getString(valido));
        }
        // Devuelve el objeto Movimiento (puede ser null si el movimiento no es válido).
        return mov;
    }

    public void pintarPosicionesPosibles(Posicion[] posiciones) {
        Pane pane;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                pane = new Pane();
                boolean posible = false;
                for (int k = 0; k < posiciones.length; k++) {
                    if (posiciones[k] != null && posiciones[k].getFila() == i && posiciones[k].getColumna() == j) {
                        pane.setStyle("-fx-background-color:#f2f47f ;");
                        posible = true;
                    }

                }
                if (!posible) {
                    if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                        pane.setStyle("-fx-background-color: #769853;");
                    } else {
                        pane.setStyle("-fx-background-color: #e7ebca;");
                    }
                }
                if (tablero.hayPieza(i, j)) {
                    pane.getChildren().addAll(new ImageView(tablero.devuelvePieza(i, j).toImage()));
                }
                mainGrid.add(pane, j, i);
            }
        }
    }




    public int alertaPromocion() {
        int opcion = 0;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(resourceBundle.getString("PROMOCION_PEON"));
        alert.setHeaderText(resourceBundle.getString("QUE_PIEZA"));
        alert.setContentText(resourceBundle.getString("SUSTITUIR_PEON"));


        ButtonType reina = new ButtonType(resourceBundle.getString("REINA"));
        ButtonType caballo = new ButtonType(resourceBundle.getString("CABALLO"));
        ButtonType alfil = new ButtonType(resourceBundle.getString("ALFIL"));
        ButtonType torre = new ButtonType(resourceBundle.getString("TORRE"));


        alert.getButtonTypes().setAll(reina, caballo, alfil, torre);

        Optional<ButtonType> result = alert.showAndWait();
        /*if (result.get().getText().equalsIgnoreCase("Reina")) {
            opcion = 1;
        } else if (result.get().getText().equalsIgnoreCase("Caballo")) {
            opcion = 2;
        } else if (result.get().getText().equalsIgnoreCase("Torre")) {
            opcion = 3;
        } else if (result.get().getText().equalsIgnoreCase("Alfil")) {
            opcion = 4;
        }*/
        if (result.isPresent()) {
            String buttonText = result.get().getText().toLowerCase(); // Convertir a minúsculas para comparar sin importar el caso
            if (buttonText.equals(resourceBundle.getString("REINA").toLowerCase())) {
                opcion = 1;
            } else if (buttonText.equals(resourceBundle.getString("CABALLO").toLowerCase())) {
                opcion = 2;
            } else if (buttonText.equals(resourceBundle.getString("TORRE").toLowerCase())) {
                opcion = 3;
            } else if (buttonText.equals(resourceBundle.getString("ALFIL").toLowerCase())) {
                opcion = 4;
            }
        }
        return opcion;
    }


    @FXML
    protected void onHelloButtonClick() {
        label.setText("Welcome to JavaFX Application!");
    }

    public void click(MouseEvent mouseEvent) {
        if (!fin) {
            int columna = 0;
            int fila = 0;
            Node node = null;
            for (int i = 0; i < mainGrid.getChildren().size(); i++) { //verfica los limites
                node = mainGrid.getChildren().get(i);
                if (node.getBoundsInParent().contains(mouseEvent.getSceneX(), mouseEvent.getSceneY())) { //recorre el bucle cuando seleccionamos con el mous algun nodo
                    columna = GridPane.getColumnIndex(node);
                    fila = GridPane.getRowIndex(node);
                }
            }
            if (posorigen == null) { //se inicializa antes de clickear a la posicion, el usuario aun no ha seleccionado, po lo que aqui se establece su posicion inicial
                Posicion pos = new Posicion(fila, columna); //se da una posicion nueva a la posicion clickeada
                Posicion[] posiciones = movimientosValidosFx(pos);  // Obtienes las posiciones válidas para la pieza en la posición clicada
                //verifica si hay al menos una posicion valida
                if (posiciones[0] != null) {
                    //estableces la posicion de origen
                    posorigen = pos;
                    pintarPosicionesPosibles(posiciones); // Pintas visualmente las posiciones a las que la pieza puede moverse
                    label2.setText(resourceBundle.getString("ELIJA_LA_POSICIÓN_A_LA_QUE_DESEA_MOVER"));
                }
            } else { //ya la ha seleccionado y ahora va a elegir su posicion de destino
                Posicion pos = new Posicion(fila, columna);
                Movimiento mov = validarPosFinalFx(pos, posorigen);  //verifica si hay posiciones finales
                //si ni es nula, o sea, las hay
                if (mov != null) {
                    if (tablero.mover(mov, juego)) { //simula el movimiento
                        int opcion = alertaPromocion(); //esto en caso de promocion, se mostraran 4 opciones
                        tablero.promocionPeonFx(mov, opcion); //se coloca la opcion y se agrega el movimiento para obtener la posicion final
                    }
                    juego.setTurno(); //cambia de turno
                    pintarTablero();
                    posorigen = null; //se reinicia la posicion de origen a null
                }
            }
            //se establece fin
            if (tablero.jaqueBlanco(juego)) {
                if (tablero.jaqueMateBlanco(juego)) {
                    tablero.pintarTablero();
                    label.setText(resourceBundle.getString("JAQUE_MATE_BLANCO"));
                    fin = true;
                }
            }
            if (tablero.jaqueNegro(juego)) {
                if (tablero.jaqueMateNegro(juego)) {
                    tablero.pintarTablero();
                    //label.setText(Constantes.JAQUE_MATE_NEGRO);
                    label.setText(resourceBundle.getString("JAQUE_MATE_NEGRO"));
                    fin = true;
                }
            }
            if (!fin && tablero.finJuego(juego)) { //en caso haya ya terminado el juego y siga en false
                fin = true;
                //label.setText(Constantes.TABLAS);
                label.setText(resourceBundle.getString("TABLAS")); //tablas
            }
            if (fin) {
                //label2.setText(Constantes.FIN_JUEGO);
                label2.setText(resourceBundle.getString("FIN_JUEGO"));
            } else {
                if (juego.getTurno().equals("B")) {
                    if (tablero.jaqueBlanco(juego)) {
                        //label2.setText(Constantes.JAQUE_BLANCO);
                        label2.setText(resourceBundle.getString("JAQUE_BLANCO"));
                    }
                    label.setText(resourceBundle.getString("TURNO_DE_BLANCAS"));
                } else {
                    if (tablero.jaqueNegro(juego)) {
                        //label2.setText(Constantes.JAQUE_NEGRO);
                        label2.setText(resourceBundle.getString("JAQUE_NEGRO"));
                    }
                    //label.setText(Constantes.TURNO_DE_NEGRAS);
                    label.setText(resourceBundle.getString("TURNO_DE_NEGRAS"));
                }
            }
        }
    }
    public void enroque(ActionEvent actionEvent) {
        String language = resourceBundle.getLocale().getLanguage();
        switch (language) {
            case "":
                loadLanguage("pt");
                setButtonText("Deutsch");
                break;
            case "pt":
                loadLanguage("de");
                setButtonText("English");
                break;
            case "de":
                loadLanguage("en");
                setButtonText("Italiano");
                break;
            case "en":
                loadLanguage("it");
                setButtonText("Español");
                break;
            case "it":
                loadLanguage("es");
                setButtonText("Português");
                break;
            default:
                loadLanguage("es");
                setButtonText("Português");
                break;
        }
    }
}