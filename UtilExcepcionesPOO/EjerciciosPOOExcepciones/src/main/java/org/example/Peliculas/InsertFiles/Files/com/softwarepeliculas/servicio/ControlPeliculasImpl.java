package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.servicio;

import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.datos.AccesoDatosImpl;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.datos.IAccesoDatos;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Pelicula;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.excepciones.AccesoDatosExcepciones;


import java.util.List;

public class ControlPeliculasImpl implements IControlPeliculas{
    private final IAccesoDatos datos ;

    public ControlPeliculasImpl() {
        this.datos =  new AccesoDatosImpl();
    }



    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;

        try {
            anexar= datos.comprobarSiEXisteArchivo(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        }catch (AccesoDatosExcepciones ae){
            System.err.println("\nError de acceso a datos");
            ae.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        String resultado = null;
        try {
                resultado= this.datos.buscar(NOMBRE_RECURSO, pelicula.getNombre());

        }catch (AccesoDatosExcepciones ae){
            System.err.println("\nError de acceso a datos");
            ae.printStackTrace(System.out);
        }

        if (resultado==null){
            System.err.println("No se ha encontrado la pelicula");
        } else {
            System.out.println("Pelicula encontrada: "+pelicula);
        }
    }

    @Override
    public void listarPeliculas() {

        try {
            List<Pelicula> peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula:peliculas){
                System.out.println(pelicula);
            }
        }catch (AccesoDatosExcepciones ae){
            System.err.println("\nError de acceso a datos");
            ae.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarControlDePeliculas() {
        try {
            if (this.datos.comprobarSiEXisteArchivo(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosExcepciones ae){
            System.err.println("\nHubo una falla");
            ae.printStackTrace(System.out);
        }
    }
}
