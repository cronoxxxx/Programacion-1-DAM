package org.example.drafts;

import org.example.dao.DaoFicherosFruta;
import org.example.dao.Fruteria;
import org.example.service.GestionFruteria;

import java.io.FileNotFoundException;

public class FileFruta
{
    public static void main(String[] args) throws FileNotFoundException {
        Fruteria fruteria = new Fruteria();
        System.out.println(fruteria.mostrarInformacion(true));

    }
}
