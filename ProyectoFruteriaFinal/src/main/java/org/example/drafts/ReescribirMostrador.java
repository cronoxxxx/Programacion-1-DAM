package org.example.drafts;

import org.example.dao.DaoFicherosFruta;
import org.example.dao.DaoMostrador;
import org.example.dao.DaoMostradorImplementacion;
import org.example.dao.Mostrador;
import org.example.domain.Cliente;
import org.example.domain.ClienteFisico;
import org.example.service.GestionMostrador;

import java.io.IOException;

public class ReescribirMostrador
{
    public static void main(String[] args) throws IOException {
        DaoFicherosFruta.crearFicheros();
        Mostrador mostrador = new Mostrador();
        DaoFicherosFruta.escribirFicheroBinario(mostrador);





    }
}
