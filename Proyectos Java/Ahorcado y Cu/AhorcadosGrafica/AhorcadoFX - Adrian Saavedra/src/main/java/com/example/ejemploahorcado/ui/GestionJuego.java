package com.example.ejemploahorcado.ui;

import com.example.ejemploahorcado.common.Categoria;
import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.domain.CategoriaDificultadExcepcion;
import com.example.ejemploahorcado.domain.Juego;
import com.example.ejemploahorcado.domain.Jugador;
import com.example.ejemploahorcado.service.GestionPalabras;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class GestionJuego {


    public static Juego juego(GestionPalabras gestionPalabras) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.MENU_JUGADOR);

        Juego juego = null;
        boolean valid = false, juegoCargado = false;
        int var = 0;
        do {
            try {

                var = entrada.nextInt();
                if (var == 1) {
                    try {
                        juego = baseJuego(gestionPalabras);
                        valid = true;
                    } catch (CategoriaDificultadExcepcion e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error");
                        alert.setContentText(Constantes.VALORES_JUEGO_NO_VALIDO);
                        alert.showAndWait();
                    }
                } else if (var == 2) {
                    juego = gestionPalabras.cargarFicheroBinario();
                    if (juego == null) {
                        System.out.println(Constantes.NO_SE_HA_PODIDO_ENCONTRAR_PARTIDA_GUARDADA);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText(Constantes.CARGANDO);
                        alert.showAndWait();
                        juegoCargado = true;
                    }
                    valid = true;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Error");
                    alert.setContentText(Constantes.OPCION_NO_VALIDA);
                    alert.showAndWait();

                }
            } catch (InputMismatchException in) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                alert.showAndWait();
            }
        } while (!valid);
        //proff
        //System.out.println(juego.getaAdivinar());
        /*if (juego != null & juegoCargado){
            juego.pintarTablero();
            juego.pintarpalabraChar();
            do {
                System.out.println(Constantes.INGRESA_LA_PALABRA_A_ADIVINAR);
                char acter = entrada.next().charAt(0);
                juego.jugada(acter);
                gestionPalabras.escribirFicheroBinario(juego);
            } while (juego.fin() == 0);
            if (juego.fin() == 1) {
                System.out.println(Constantes.HAS_GASTADO_TODOS_TUS_INTENTOS_GAME_OVER);
                System.out.println(Constantes.ESTA_ERA_LA_PALABRA_QUE_TENIAS_QUE_ADIVINAR + juego.getaAdivinar().getIncognita());
                gestionPalabras.escribirFicheroBinario(juego);
            } else if (juego.fin() == 2) {
                System.out.println(Constantes.ENHORABUENA_LO_HAS_LOGRADO);
                gestionPalabras.escribirFicheroBinario(juego);
            }
        } else {
            System.out.println(Constantes.ERRORES);
        }*/

        return juego;
    }


    private static Juego baseJuego(GestionPalabras gestionPalabras) throws CategoriaDificultadExcepcion {

        TextInputDialog nombreDialog = new TextInputDialog();
        nombreDialog.setTitle("Ahorcados");
        nombreDialog.setHeaderText(Constantes.INTRODUZCA_SU_NOMBRE);
        nombreDialog.setContentText("Por favor, introduzca su nombre:");
        Scanner entrada = new Scanner(System.in);

        //System.out.println(Constantes.INTRODUZCA_SU_NOMBRE);
        Optional<String> nombreResult = nombreDialog.showAndWait();
        Jugador jugador = null;
        String categoria = null;
        int lvl = -1;
        if (nombreResult.isPresent()) {
            String nombre = nombreResult.get();
            jugador = new Jugador(nombre);
            while (lvl != 0 && lvl != 1) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setHeaderText(Constantes.INTRODUZCA_LA_DIFICULTAD);
                dialog.setContentText("Por favor, introduzca la dificultad (0 para fácil, 1 para difícil):");
                Optional<String> result = dialog.showAndWait();

                if (result.isPresent()) {
                    try {
                        lvl = Integer.parseInt(result.get());
                    } catch (NumberFormatException e) {
                        // Manejar la entrada no válida
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error");
                        alert.setContentText(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                        alert.showAndWait();
                    }

                    if (lvl!=0 && lvl!=1){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Error");
                        alert.setContentText(Constantes.VALORES_JUEGO_NO_VALIDO);
                        alert.showAndWait();
                    }
                }
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(Constantes.INTRODUZCA_LA_CATEGORIA);
            alert.setContentText(Arrays.toString(Categoria.values()).replace("[", "").replace("]", ""));


            alert.getButtonTypes().clear(); //quitar botones de aceptar y cancelar

            for (Categoria categorias : Categoria.values()) {
                ButtonType botonCategoria = new ButtonType(categorias.toString());
                alert.getButtonTypes().add(botonCategoria);
            }

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent()) {
                ButtonType botonSeleccionado = result.get();
                categoria = botonSeleccionado.getText(); // Obtener el texto del botón seleccionado
            }
            gestionPalabras.getDaoPalabras().categoriaDificultadOK(categoria, lvl);
        }
        return new Juego(jugador, lvl, categoria, gestionPalabras.getDaoPalabras().getLista().getPalabraDificultadCategoria(lvl, categoria));
    }


}
