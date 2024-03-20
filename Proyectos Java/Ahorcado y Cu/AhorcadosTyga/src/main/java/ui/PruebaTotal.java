package ui;

import common.CategoriaException;
import common.Constantes;

import java.util.Scanner;

public class PruebaTotal {

    public static void iniciarMenuJuego () throws CategoriaException {
        Scanner entrada= new Scanner(System.in);

        int variant = 0;
        do {
            System.out.println(Constantes.MEEEEEEENUUUUU_PRIIIINCIIIPAAAL__UIIIIII);
            variant= entrada.nextInt();
            switch (variant){
                case 1-> GestionDiccionario.gestion();
                case 2 -> GestionJuego.juego();
                case 3 -> System.out.println(Constantes.VUELVA_PRONTO);
                default -> System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
            }
        }while (variant!=3);



    }
}
