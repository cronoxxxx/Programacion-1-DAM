package EJERCICIOS.CLASESYOBJETOS.Inicial.amplios.oca;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);

        Tablero tablero = new Tablero();
        String resp = null;
        Jugada jugada = new Jugada();

        do {

            do {
                tablero.mostrarTablero();
                System.out.println("\nJugador 1: Fulanito, casilla "+tablero.getPosicionJugadorX());
                System.out.println("Jugador 2: Menganito, casilla "+tablero.getPosicionJugadorY());
                System.out.println("\nDesea continuar? (s/n)");
                resp = entrada.next();

                if (resp.strip().equalsIgnoreCase("s")){
                    if (jugada.isTurno()) {
                        System.out.println("Turno de Fulanito");
                        tablero.realizarMovimiento(jugada);
                        jugada.setTurno(false);
                    } else {
                        System.out.println("Turno de Menganito");
                        tablero.realizarMovimiento(jugada);
                        jugada.setTurno(true);
                    }
                } else if (resp.strip().equalsIgnoreCase("n")) {
                    System.out.println("SALIENDO DEL PROGRAMA");
                } else {
                    System.out.println("Inserte una respuesta valida");
                }

            } while (!(resp.strip().equalsIgnoreCase("s") || resp.strip().equalsIgnoreCase("n")));
        }while (!resp.strip().equalsIgnoreCase("n") );

    }
}
