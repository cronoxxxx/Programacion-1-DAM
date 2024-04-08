package exdrafts.com.software.peliculas.dao;

import exdrafts.com.software.peliculas.domain.Pelicula;

import java.util.List;

public interface IAccesoDatos {
    //Creamos los metodos necesarios para ejecutar operaciones al archivo
    boolean comprobarSiExisteArchivo(String nombreRecurso) throws AccesoDatosExcepcion;

    List<Pelicula> listaPeliculas(String nombreRecurso) throws LecturaDatosExcepcion;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion; //Tendremos que leer para buscar la pelicula

    void crear(String nombreRecurso) throws AccesoDatosExcepcion;

    void borrar(String nombreRecurso) throws AccesoDatosExcepcion;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepcion;


}
