package org.example.drafts;

import org.example.dao.*;
import org.example.domain.Cliente;
import org.example.domain.ClienteFisico;
import org.example.service.GestionMostrador;

import java.io.IOException;

public class ReescribirMostrador
{
    public static void main(String[] args) throws IOException {
        DaoFicherosFruta.crearFicheros();
        Database database = new Database();
        DaoFicherosFruta.escribirFicheroBinarioData(database);





    }
}
