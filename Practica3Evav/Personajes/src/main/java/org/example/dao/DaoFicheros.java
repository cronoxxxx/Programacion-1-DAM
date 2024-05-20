package org.example.dao;

import org.example.common.AddHabilidadesException;
import org.example.domain.Campeon;
import org.example.domain.Mago;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DaoFicheros {
    private static final String rutaTXT = "data/Magos.txt";
    private static final String rutaBIN = "data/Data.bin";

    public static boolean escribirFichero(List<Campeon> aParsear) {
        List<Mago> agregarMagos = new ArrayList<>();
        for (int i = 0; i < aParsear.size(); i++) {
            if (aParsear.get(i) instanceof Mago) {
                agregarMagos.add((Mago) aParsear.get(i));
            }
        }

        try {
            PrintWriter pw = new PrintWriter(rutaTXT);
            for (int i = 0; i < agregarMagos.size(); i++) {
                pw.println(agregarMagos.get(i).toStringFile());
            }
            pw.close();
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Mago> leerFichero() {
        List<Mago> magos = null;
        File fichero = new File(rutaTXT);
        try (Scanner entrada = new Scanner(fichero)) {
            magos = new ArrayList<>();
            while (entrada.hasNextLine()) {
                String cadena = entrada.nextLine();
                String[] pieces = cadena.split(";");
                int numSkins = Integer.parseInt(pieces[0]);
                String nombre = pieces[1];
                double ataque = Double.parseDouble(pieces[2]);
                double altura = Double.parseDouble(pieces[3]);
                List<String> habilidades = Arrays.asList(pieces[4].split(","));
                boolean stunt = Boolean.parseBoolean(pieces[5]);
                Mago mago = new Mago(numSkins, nombre, ataque, altura, habilidades, stunt);
                magos.add(mago);

            }
        } catch (FileNotFoundException | AddHabilidadesException e) {
            throw new RuntimeException(e);
        }
        return magos;
    }

    public static boolean escribirBinario(Database database) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(rutaBIN))) {
            os.writeObject(database);
            escrito = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return escrito;
    }

    public static Database leerBinario (){
        Database database = null;
        try (ObjectInputStream os = new ObjectInputStream(new FileInputStream(rutaBIN))) {
            database = (Database) os.readObject();
        }  catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return database;
    }
}
