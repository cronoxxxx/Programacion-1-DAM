package org.example.dao;



import org.example.common.Constantes;
import org.example.common.FechaInvalidaException;
import org.example.common.precioVentaExcepcion;
import org.example.domain.Fruta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoFicherosFruta {


    private static String FICHERO = "Fichero", FICHEROBINARIO = "FicheroBinario.bin";

    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROBINARIO);
        if (!fichero1.exists()) {
            fichero1.createNewFile();
        }
        if (!fichero2.exists())
            fichero2.createNewFile();
    }

    public static boolean escribirFichero(List<Fruta> frutas) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(FICHERO);
        for (int i = 0; i < frutas.size(); i++) {
            pw.println(frutas.get(i).toStringFile());
        }
        pw.close();
        return true;
    }


    public static List<Fruta> leerFichero() throws FileNotFoundException {
        List<Fruta> frutas = null;
        File fichero = new File(FICHERO);
        try (Scanner sc = new Scanner(fichero)) {
            frutas = new ArrayList<>();
            while ((sc.hasNextLine())) {
                String cadena = sc.nextLine();
                String[] partes = cadena.split(";");
                if (partes.length >=5) { // Verificar que hay 5 partes en la línea
                    String nombre = partes[0];
                    String procedencia = partes[1];
                    int numeroKilos = Integer.parseInt(partes[2]);
                    double precioCostePorKilo = Double.parseDouble(partes[3]);
                    double precioVentaPorKilo = Double.parseDouble(partes[4]);
                    LocalDate fechaCaducidad = LocalDate.parse(partes[5]);
                    Fruta fruta = new Fruta(nombre, procedencia, numeroKilos, precioCostePorKilo, precioVentaPorKilo,fechaCaducidad);
                    frutas.add(fruta);
                } else {
                    System.out.println(Constantes.FORMATO_INCORRECTO_EN_LA_LINEA + cadena);
                    // Manejo de líneas con formato incorrecto si es necesario
                }
            }
        } catch (IOException e) {
            // Manejo de errores de lectura
            e.printStackTrace();
        } catch (precioVentaExcepcion | FechaInvalidaException e) {
            System.out.println(e.getMessage());
        }
        return frutas;
    }



}
