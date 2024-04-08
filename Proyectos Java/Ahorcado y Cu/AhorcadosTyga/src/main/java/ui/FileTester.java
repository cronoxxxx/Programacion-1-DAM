package ui;

import dao.DaoPalabrasFicheros;
import dao.DaoPalabrasImplementacion;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTester {
    public static void main(String[] args) {
        DaoPalabrasImplementacion a = new DaoPalabrasImplementacion();
        try {
            DaoPalabrasFicheros.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            DaoPalabrasFicheros.escribirFichero(a.getPalabrasOrdenadas(true),DaoPalabrasFicheros.FICHERO);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            DaoPalabrasFicheros.leerFile(DaoPalabrasFicheros.FICHERO);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        a.eliminarPalabra(2); //se borra  tmb del fichero
        try {
            DaoPalabrasFicheros.escribirFichero(a.getPalabrasOrdenadas(true),DaoPalabrasFicheros.FICHERO);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        System.out.println("par");
        try {
            DaoPalabrasFicheros.leerFile(DaoPalabrasFicheros.FICHERO);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
