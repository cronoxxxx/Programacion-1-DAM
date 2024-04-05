package ui;

import domain.*;
import common.*;

import java.util.*;

public class GestionJuego {


    public static void juego() {
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.MENU_JUGADOR);
        Juego juego = null;
        boolean valid = false;
        int var = 0;
        do {
            try {
                var = entrada.nextInt();
            } catch (InputMismatchException in) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                entrada.nextLine();
            }
        } while (!(var == 1 || var == 2));
        do {
            if (var == 1) {
                try {
                    juego = baseJuego();
                    valid = true;
                } catch (CategoriaDificultadExcepcion e) {
                    System.out.println(Constantes.VALORES_JUEGO_NO_VALIDO);
                    entrada.nextLine();
                }
            } else {
                //por ahora se volvera 1, luego le agregare los ficheros
                var = 1;
            }
        } while (!valid);
        //proff
        //System.out.println(juego.getaAdivinar());
        juego.pintarTablero();
        juego.pintarpalabraChar();
        do {
            System.out.println(Constantes.INGRESA_LA_PALABRA_A_ADIVINAR);
            char acter = entrada.next().charAt(0);
            juego.jugada(acter);
        } while (juego.fin() == 0);
        if (juego.fin() == 1) {
            System.out.println(Constantes.HAS_GASTADO_TODOS_TUS_INTENTOS_GAME_OVER);
            System.out.println(Constantes.ESTA_ERA_LA_PALABRA_QUE_TENIAS_QUE_ADIVINAR+juego.getaAdivinar().getIncognita());
        } else if (juego.fin() == 2) {
            System.out.println(Constantes.ENHORABUENA_LO_HAS_LOGRADO);
        }
    }


    private static Juego baseJuego() throws CategoriaDificultadExcepcion {
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.INTRODUZCA_SU_NOMBRE);
        String nombre = entrada.nextLine();
        Jugador jugador = new Jugador(nombre);
        int lvl = 0;
        do {
            System.out.println(Constantes.INTRODUZCA_LA_DIFICULTAD);
            try {
                lvl = entrada.nextInt();
            } catch (InputMismatchException i) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                entrada.nextLine();
            }
        } while (!(lvl == 0 || lvl == 1));
        entrada.nextLine();
        System.out.println(Constantes.INTRODUZCA_LA_CATEGORIA);
        String categoria = null;
        categoria = entrada.nextLine();


        return new Juego(jugador, lvl, categoria);
    }


}
