package org.example.ui;

import org.example.common.Constantes;
import org.example.service.GestionFruteria;

public class MenuPrograma {
    public static void main(String[] args) {
        GestionFruteria gestionFruteria = new GestionFruteria();

        InterfazFruteria.getInterfazFruteria(gestionFruteria);
    }
}
