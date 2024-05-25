package org.example.drafts;

import org.example.dao.DaoFicherosFruta;
import org.example.dao.Mostrador;
import org.example.domain.Cliente;

import java.util.Map;

public class Mew

{
    public static void main(String[] args) {
        Mostrador mostrador = DaoFicherosFruta.leerFicheroBinario();
        Map<Integer, Cliente> mostrarInformacion = mostrador.mostrarInformacion(true);
        System.out.println(mostrarInformacion);

        mostrador.removeClienteporID(2);


        System.out.println(mostrarInformacion);
    }
}
