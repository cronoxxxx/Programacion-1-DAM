package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.datos;

import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Pelicula;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.excepciones.*;

import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {
    @Override
    public boolean comprobarSiEXisteArchivo(String nombreRecurso) throws AccesoDatosExcepciones {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEXcepciones {
        File archivo = new File(nombreRecurso);
        List <Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            /*while ((contenido= entrada.readLine())!=null){
                Pelicula pelicula = new Pelicula(contenido);
                peliculas.add(pelicula);
            }*/
            for (String contenido = entrada.readLine(); contenido != null; contenido = entrada.readLine()) {
                System.out.println(contenido);
            }
            entrada.close();
        }catch (IOException err){
            err.printStackTrace(System.out);
            throw new LecturaDatosEXcepciones("Excepcion al leer peliculas: "+err.getMessage());
        }
        return peliculas;
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEXcepciones {
        File archivo = new File(nombreRecurso);
        String resultado = null;

        try {
                boolean encontrado = false;
                BufferedReader salida = new BufferedReader(new FileReader(archivo)); //el buffer crea una memoria temporal, pasando como argumento el lector del archivo
                String linea; //para leer lineas
                for (int indice = 1; (linea = salida.readLine()) != null && !encontrado; indice++) {
                if (buscar != null && !buscar.trim().isEmpty() && buscar.trim().equalsIgnoreCase(linea)) {
                    encontrado = true;
                    System.out.println(" ");
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                }
            }
                salida.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEXcepciones("Excepcion al buscar en la pelicula: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepciones {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar)); //true para seguir añadiendo contenido, es decir, que no se resetee
            salida.println(pelicula+"\n");
            salida.close();
            System.out.println("Se ha añadido la pelicula: "+pelicula.getNombre()+"\n");
        }catch (IOException e ){
            e.printStackTrace(System.out);
            throw new EscrituraDatosExcepciones("Excepcion al escribir en el archivo en el archivo: "+e.getMessage());
        }
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepciones {//Crea lectura
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo)); //autoriza la lectura del archivo
            salida.close();
            System.out.println("Se ha creado el archivo\n");
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepciones("Excepcion al crear archivo "+e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepciones {
            File archivo = new File(nombreRecurso);
            if (archivo.delete()){
                System.out.println("Se ha borrado el archivo");
            } else {
                System.err.println("El archivo "+archivo+" ya existe");
            }
    }
}
