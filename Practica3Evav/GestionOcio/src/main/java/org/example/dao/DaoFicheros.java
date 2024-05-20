package org.example.dao;

import org.example.common.Constantes;
import org.example.common.correoException;
import org.example.common.precioEntradaException;
import org.example.common.valoracionException;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoologico;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DaoFicheros {

    private static String FICHERO = "data/Fichero", FICHEROBINARIO = "data/Info.bin";

    public static void crearFicheros() throws IOException {
        File fichero1 = new File(FICHERO);
        File fichero2 = new File(FICHEROBINARIO);
        if (!fichero1.exists()) {
            fichero1.createNewFile();
        }
        if (!fichero2.exists())
            fichero2.createNewFile();


    }

    public static boolean escribirFichero(List<Zoologico> frutas) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(FICHERO);
        for (int i = 0; i < frutas.size(); i++) {
            pw.println(frutas.get(i).toStringFile());
        }
        pw.close();
        return true;
    }


    public static List<Zoologico> leerFichero() throws FileNotFoundException {
        List<Zoologico> zoologicos = null;
        File fichero = new File(FICHERO);
        try (Scanner sc = new Scanner(fichero)) {
            zoologicos = new ArrayList<>();
            while ((sc.hasNextLine())) {
                String cadena = sc.nextLine();
                String[] partes = cadena.split(";");
                if (partes.length >=5) { // Verificar que hay 5 partes en la línea
                    int valoracion = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String provincia = partes[2];
                    String correoAtencion = partes[3];
                    LocalDate fechaAlta = LocalDate.parse(partes[4]);
                    double precioEntrada = Double.parseDouble(partes[5]);
                    List<String> servicios = Arrays.asList(partes[6].split(","));
                    Zoologico zoo = new Zoologico(valoracion, nombre, provincia, correoAtencion, fechaAlta, precioEntrada, servicios);
                    zoologicos.add(zoo);
                } else {
                    System.out.println(Constantes.FORMATO_INCORRECTO_EN_LA_LINEA + cadena);
                    // Manejo de líneas con formato incorrecto si es necesario
                }
            }
        } catch (IOException e) {
            // Manejo de errores de lectura
            e.printStackTrace(System.out);
        } catch (precioEntradaException | valoracionException | correoException e) {
            System.out.println(e.getMessage());
        }
        return zoologicos;
    }

    public static boolean escribirBinarioDatabase (Database database) throws IOException {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROBINARIO))) {
            os.writeObject(database);
            escrito = true;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return escrito;
    }

    public static Database leerBinarioDatabase () throws IOException, ClassNotFoundException {
        Database database = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FICHEROBINARIO))) {
            database = (Database) is.readObject();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return database;
    }
}
