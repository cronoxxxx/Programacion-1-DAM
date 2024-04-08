package exdrafts.com.software.peliculas.service;

import exdrafts.com.software.peliculas.common.Constantes;
import exdrafts.com.software.peliculas.dao.AccesoDatosExcepcion;
import exdrafts.com.software.peliculas.dao.AccesoDatosImpl;
import exdrafts.com.software.peliculas.dao.IAccesoDatos;
import exdrafts.com.software.peliculas.domain.Pelicula;

import java.util.List;

public class ControlPeliculasImpl implements IControlPeliculas{
    private IAccesoDatos datos;

    public ControlPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }



    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pel = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try{
            anexar = datos.comprobarSiExisteArchivo(NOMBRE_RECURSO); //si es true, si existe el archivo, se anexa y se sigue sobreescribiendo
            datos.escribir (pel,NOMBRE_RECURSO,anexar);
        }catch (AccesoDatosExcepcion e){
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try{
            List<Pelicula> pel = datos.listaPeliculas(NOMBRE_RECURSO);
            for(Pelicula p : pel){
                System.out.println(p);
            }
        }catch (AccesoDatosExcepcion e){
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String peliculaBuscar) {
        String resultado=null;
        try{
            resultado=datos.buscar(NOMBRE_RECURSO,peliculaBuscar);
        }catch (AccesoDatosExcepcion a){
            System.out.println(a.getMessage());
            a.printStackTrace(System.out);
        }
        if (resultado==null){
            System.out.println(Constantes.NO_SE_HA_ENCONTRADO_LA_PALABRA);
        } else {
            System.out.println(Constantes.PELICULA_ENCONTRADA + resultado);
        }
    }

    @Override
    public void iniciarControlDePeliculas() {
        try {
            if(datos.comprobarSiExisteArchivo(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosExcepcion a){
            System.out.println(a.getMessage());
            a.printStackTrace(System.out);
        }
    }
}
