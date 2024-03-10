package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.datos;

import java.util.*;

public class Prueba {
    public static void main(String[] args) {
        List<String> listaPeliculas = new ArrayList<>();
        listaPeliculas.add("Titanic");
        listaPeliculas.add("Titan");

        for (String pelicula:listaPeliculas ) {
            System.out.println(pelicula);
        }
    }
}
