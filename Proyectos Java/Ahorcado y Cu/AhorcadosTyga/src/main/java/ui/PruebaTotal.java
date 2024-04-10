package ui;

import common.CategoriaException;
import common.Constantes;
import service.GestionPalabras;

import java.util.Scanner;

public class PruebaTotal {

    public static void iniciarMenuJuego ()  {
        Scanner entrada= new Scanner(System.in);
        GestionPalabras gestionPalabras = new GestionPalabras();
        int variant = 0;
        do {
            System.out.println(Constantes.MEEEEEEENUUUUU_PRIIIINCIIIPAAAL__UIIIIII);
            variant= entrada.nextInt();
            switch (variant){
                case 1-> {
                    try {
                        GestionDiccionario.gestion(gestionPalabras);
                    } catch (CategoriaException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> GestionJuego.juego(gestionPalabras);
                case 3 -> System.out.println(Constantes.VUELVA_PRONTO);
                default -> System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
            }
        }while (variant!=3);



    }
}
