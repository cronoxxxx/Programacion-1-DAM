package com.example.ejemploahorcado.dao;

import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.domain.Juego;
import com.example.ejemploahorcado.domain.Palabra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoPalabrasFicheros {
    public static final String FICHERO = "Fichero";
    public static final String FICHEROB = "FicheroBinario";
    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROB);
        if (!fichero1.exists()) {
            fichero1.createNewFile();
        }
        if (!fichero2.exists())
            fichero2.createNewFile();
    }

    //Un poco obsoleto la verdad xd
    public static List<Palabra> leerFichero() throws IOException {
        return leerFichero(FICHERO);
    }
    public static List<Palabra> leerFichero(String fichero) throws IOException {
        ArrayList<Palabra> auxiliar = null;
        try (Scanner sc = new Scanner(new File(fichero))) {
            auxiliar = new ArrayList<>();
            while (sc.hasNextLine()) {
                String cadena = sc.nextLine();
                String[] trozos = cadena.split(";");
                try {
                     Palabra palabra = new Palabra(Integer.parseInt(trozos[0]), Integer.parseInt(trozos[1]), trozos[2], trozos[3]);
                    auxiliar.add(palabra);
                } catch (CategoriaException e) {
                    throw new RuntimeException(e);
                }
            };
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

        }

        return auxiliar;

    }

    public static void leerFile(String nombreFichero) throws IOException {

        Scanner lector = new Scanner(new File(nombreFichero));
        String cadena;
        while (lector.hasNextLine()) {
            System.out.println(lector.nextLine());
        }
        System.out.println("Se ha alcanzado el final del fichero");
    }

    public static boolean escribirFichero(List<Palabra> lista, String nombreFichero) throws FileNotFoundException {
        String cadena = null;
        PrintWriter pw = new PrintWriter(nombreFichero);
        //? si no está vacía
        for (int i = 0; i < lista.size(); i++) {
            pw.println(lista.get(i).toStringFile());
        }
        pw.close();
        return true;
    }

    /*public static boolean insertarPalabra(Palabra nuevaPalabra, String nombreArchivo) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo, true)); // Abrir el archivo en modo de añadir (append)
        pw.println(nuevaPalabra.toStringFile());
        pw.close();
        return true;
    }*/

    /**
     * Ejemplo de lectura de fichero binario. Pensad cómo utilizarlo para guardar y recuperar partida, guardando el objeto juego
     * en vez del ArrayList
     * @return
     */
    public static Juego leerFicheroBinario()  {
        Juego auxiliar = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROB))) {
            auxiliar = (Juego) is.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return auxiliar;
    }



    public static boolean escribirFicheroBinario(Juego juego) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(juego);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoPalabrasFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
  }
