package com.example.ejemploahorcado.ui;

import com.example.ejemploahorcado.AhorcadoVisual;
import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.service.GestionPalabras;

import java.util.Scanner;

public class PruebaTotal {
    public static void iniciarMenuJuego() {
        GestionPalabras gestionPalabras = new GestionPalabras();
        Scanner entrada = new Scanner(System.in);

        int variant = 0;
        do {
            System.out.println(Constantes.MEEEEEEENUUUUU_PRIIIINCIIIPAAAL__UIIIIII);
            variant = entrada.nextInt();
            switch (variant) {
                case 1 -> {
                    try {
                        GestionDiccionario.gestion(gestionPalabras);
                    } catch (CategoriaException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> AhorcadoVisual.main(null);
                // GestionJuego.juego(gestionPalabras);
                case 3 -> System.out.println(Constantes.VUELVA_PRONTO);
                default -> System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
            }
        } while (variant != 3);


    }
}
