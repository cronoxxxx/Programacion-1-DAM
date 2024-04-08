package ui;


import common.Categoria;
import common.CategoriaException;
import common.Comprobacion;
import dao.DaoPalabrasFicheros;
import dao.IDException;
import dao.Palabras;
import domain.Juego;
import domain.Palabra;
import net.datafaker.Faker;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        try {
            DaoPalabrasFicheros.crearFicheros();
            System.out.println("Creado con exito");
            DaoPalabrasFicheros.leerFichero(DaoPalabrasFicheros.FICHERO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            PruebaTotal.iniciarMenuJuego();
        } catch (CategoriaException e) {
            throw new RuntimeException(e);
        }
    }
}


