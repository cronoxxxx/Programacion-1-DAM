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
        PrintWriter pw = new PrintWriter(FICHEROTXT);
        for (Pista pista : pistas) {
            pw.println(pista.getClass().getSimpleName()+ pista.toStringFile());
        }
        pw.close();
        return true;
    }


    public static List<Pista> leerFichero (){
        List <Pista> pista = null;
        Pista pista1 = null;
        File fichero = new File(FICHEROTXT);
        try (Scanner entrada = new Scanner(fichero)){
            pista = new ArrayList<>();
            while (entrada.hasNextLine()){



                String cadena = entrada.nextLine();
                String [] pieces = cadena.split(";");
                int id = Integer.parseInt(pieces[1]);
                String nombre = pieces[2];
                String provincia = pieces[3];
                double kmEntension = Double.parseDouble(pieces[4]);
                if (pieces[0].equalsIgnoreCase(SkiAlpino.class.getSimpleName())){
                    String dificultad = pieces[5];
                     pista1 = new SkiAlpino(id,nombre,provincia,kmEntension,dificultad);
                } else if (pieces[0].equalsIgnoreCase(SkiFondo.class.getSimpleName())){
                    pista1 = new SkiFondo(id,nombre,provincia,kmEntension,puebloSet(pieces[5]));
                }
                pista.add(pista1);

            }
        } catch (IOException e){
            e.printStackTrace(System.out);
        } catch (DificultadException e) {
            throw new RuntimeException(e);
        }

        return pista;
    }

    public static Set<Pueblo> puebloSet(String s){
        Set<Pueblo> tuputamadre = new HashSet<>();
        String[] e = s.split(",");
        for (String eaaa : e) {
            tuputamadre.add(new Pueblo(eaaa));
        }
        return  tuputamadre;
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
