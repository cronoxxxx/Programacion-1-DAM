package org.example.drafts;

import org.example.common.AgregarProvinciasException;
import org.example.common.Constantes;
import org.example.common.EnumComprobacionDirecta;
import org.example.dao.Fruteria;

import java.util.Scanner;

public class ReescribirFrutas {
    public static void main(String[] args) {
        Fruteria fruteria = new Fruteria();
        Scanner entrada= new Scanner(System.in);
        String procedencia = null;
        System.out.println(Constantes.INGRESE_LA_PROCENDENCIA);
        do {
            procedencia = entrada.nextLine();
            try {
                EnumComprobacionDirecta.provinciaOK(procedencia);
            } catch (AgregarProvinciasException e) {
                System.out.println(Constantes.LA_PROCENDENCIA_INGRESADA_NO_ES_VALIDA_POR_FAVOR_INGRESA_UNA_PROVINCIA_EXISTENTE);
                procedencia = ""; // Reiniciar la procedencia para volver a solicitarla
            }
        } while (procedencia.isEmpty());
        if (fruteria.reunirFrutasporProcedencia(procedencia)){
            System.out.println("Exito");
        } else {
            System.err.println("no ");
        }
    }
}
