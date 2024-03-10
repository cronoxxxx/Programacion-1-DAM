package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.datos;

import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Pelicula;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.excepciones.AccesoDatosExcepciones;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.excepciones.EscrituraDatosExcepciones;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.excepciones.LecturaDatosEXcepciones;

import java.util.List;

public interface IAccesoDatos {

    //Creamos los metodos necesarios para ejecutar operaciones al archivo
    public boolean comprobarSiEXisteArchivo(String nombreRecurso) throws AccesoDatosExcepciones;


    /*int ar[] = {20,10,30,42,1}

    Pelicula [] arregloPeliculas = new Pelicula [10];

    List<Pelicula> listaPeliculas = new ArrayList()<> -- es un arreglo dinamico, o sea, no tiene un tamaño
    listaPeliculas.add(new Pelicula("Titan"));

    List <String> lista = new ArrayList<>();
    lista.add ("Saludos");

    */

    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEXcepciones;

    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEXcepciones; //para buscar, tmb vamos a tener que leer

    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepciones;

    public void crear(String nombreRecurso) throws AccesoDatosExcepciones;

    public void borrar(String nombreRecurso) throws AccesoDatosExcepciones;


}
