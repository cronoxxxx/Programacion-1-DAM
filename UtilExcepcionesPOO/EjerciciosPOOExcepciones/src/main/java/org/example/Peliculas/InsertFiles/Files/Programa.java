package org.example.Peliculas.InsertFiles.Files;

import java.io.*;

public class Programa implements Serializable {
    private Pelicula[]peliculas;

    public Programa(int cantidad){
        peliculas= new Pelicula[cantidad];
    }

    public Programa(){
        peliculas= new Pelicula[100];
    }

    public void addPelicula(Pelicula pelicula){
        boolean hayHueco = false;
        for (int i = 0; i < peliculas.length && !hayHueco; i++) {
            if (peliculas[i]==null){
                peliculas[i]=pelicula;
                hayHueco=true;
            }
        }

        if (!hayHueco){
            System.err.println("No hay hueco para añadir pelicula");
        }
    }

    public void listarPeliculas(){
        int contador = 0;
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i]!=null){
                System.out.println(peliculas[i]);
                contador++;
            }
        }
        if (contador==0){
            System.out.println("No hay peliculas para alistar");
        }
    }

    public void buscarPelicula (String nombre){
        boolean hayPelicula = false;
        for (int i = 0; i < peliculas.length && !hayPelicula; i++) {
            if (peliculas[i]!=null){
               if (nombre.trim().equalsIgnoreCase(peliculas[i].getNombre())){
                   System.out.println(peliculas[i]);
                   hayPelicula=true;
                   i=peliculas.length-1;
               }
            }
        }

        if (!hayPelicula){
            System.err.println("No hay pelicula");
        }
    }









}
