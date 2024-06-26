package org.example.ui;

import lombok.extern.log4j.Log4j2;
import org.example.common.Constantes;

import org.example.service.GestionFruteria;
import org.example.service.GestionMostrador;

import java.io.*;
@Log4j2
public class MenuPrograma {
    public static void action() {
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        GestionMostrador gestionMostrador = new GestionMostrador();
        GestionFruteria gestionFruteria = new GestionFruteria();
        try {
            int var;
            do {
                System.out.println(Constantes.MENU_BIENVENIDA);
                var = Integer.parseInt(entradaReader.readLine());
                switch (var) {
                    case 1 -> {
                        InterfazMostrador.getInterfazMostrador(gestionMostrador);
                        var = 3;
                    }
                    case 2 -> {
                        InterfazFruteria.getInterfazFruteria(gestionFruteria);
                        var = 3;
                    }
                    case 3 -> System.out.println(Constantes.VUELVA_PRONTO);
                    default -> System.out.println(Constantes.OPCION_NO_VALIDA);
                }
            } while (var != 3);

        } catch (IOException | NumberFormatException e) {
            log.error(e.getMessage(),e);
        }







    }
}
