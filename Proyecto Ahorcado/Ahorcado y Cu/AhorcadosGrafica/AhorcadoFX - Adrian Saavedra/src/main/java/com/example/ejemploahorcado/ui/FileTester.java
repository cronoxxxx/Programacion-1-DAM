package com.example.ejemploahorcado.ui;

import com.example.ejemploahorcado.dao.DaoPalabrasFicheros;
import com.example.ejemploahorcado.dao.DaoPalabrasImplementacion;
import com.example.ejemploahorcado.dao.Palabras;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTester {
    public static void main(String[] args) {
        /*DaoPalabrasImplementacion a = new DaoPalabrasImplementacion();
        try {
            // Crear los archivos si no existen
            DaoPalabrasFicheros.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // Escribir las palabras ordenadas en el archivo
            DaoPalabrasFicheros.escribirFichero(a.getPalabrasOrdenadas(true), DaoPalabrasFicheros.FICHERO);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



// Insertar una nueva palabra
        Palabras p = new Palabras();

        try {
            DaoPalabrasFicheros.insertarPalabra(p.getPalabraDificultadCategoria(1,"pokemon"), DaoPalabrasFicheros.FICHERO);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.print(".");
        }
        try {
            // Leer y mostrar el contenido del archivo
            DaoPalabrasFicheros.leerFile(DaoPalabrasFicheros.FICHERO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/
    }
}
