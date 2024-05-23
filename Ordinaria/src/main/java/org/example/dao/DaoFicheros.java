package org.example.dao;

import org.example.common.DificultadException;
import org.example.domain.Pista;
import org.example.domain.Pueblo;
import org.example.domain.SkiAlpino;
import org.example.domain.SkiFondo;

import java.io.*;
import java.util.*;

public class DaoFicheros {

    public static final String FICHEROTXT =  "data/fichero.txt";
    public static final String BINARIO = "data/pistas.bin";


    public static void crearFicheros () throws IOException {
        File f1 = new File(FICHEROTXT);
        File f2 = new File (BINARIO);
        if (!f1.exists()){
            f1.createNewFile();
        }
        if (!f2.exists()){
            f2.createNewFile();
        }
    }

    public static boolean escribirFichero (List<Pista> pistas) throws FileNotFoundException {
        List<SkiAlpino> addAlpinos = new ArrayList<>();
        List<SkiFondo> addFondos = new ArrayList<>();
        PrintWriter pw = new PrintWriter(FICHEROTXT);
        for (Pista pista : pistas) {
                if (pista instanceof SkiAlpino) {
                    addAlpinos.add((SkiAlpino) pista);
                }
        }

        for (int i = 0; i < addAlpinos.size(); i++) {
            pw.println(addAlpinos.get(i).toStringFile());
        }
        pw.close();
        return true;
    }


    public static List<Pista> leerFichero (){
        List <Pista> pista = null;
        File fichero = new File(FICHEROTXT);
        try (Scanner entrada = new Scanner(fichero)){
            pista = new ArrayList<>();
            while (entrada.hasNextLine()){
                String cadena = entrada.nextLine();
                String [] pieces = cadena.split(";");
                int id = Integer.parseInt(pieces[0]);
                String nombre = pieces[1];
                String provincia = pieces[2];
                double kmEntension = Double.parseDouble(pieces[3]);

                String dificultad = pieces[4];
                SkiAlpino skiAlpino = new SkiAlpino(id,nombre,provincia,kmEntension,dificultad);
                pista.add(skiAlpino);

            }
        } catch (IOException e){
            e.printStackTrace(System.out);
        } catch (DificultadException e) {
            throw new RuntimeException(e);
        }

        return pista;
    }



    public static boolean escribirBinario (Pistas pistas){
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(BINARIO))){
            os.writeObject(pistas);

            escrito=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return escrito;
    }

    public static Pistas leerBinario (){
        Pistas pistas = null;
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(BINARIO))){
            pistas = (Pistas) is.readObject();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace(System.out);
        }
        return pistas;
    }


}
