package org.example.drafts;

import org.example.dao.DaoFicherosFruta;
import org.example.dao.Mostrador;
import org.example.domain.Cliente;
import org.example.domain.ClienteFisico;

public class ReescribirMostrador
{
    public static void main(String[] args) {
        Mostrador mostrador = DaoFicherosFruta.leerFicheroBinario();
        System.out.println(mostrador.mostrarInformacion(true));


    }
}
