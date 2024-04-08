package exdrafts.com.software.peliculas.dao;

import exdrafts.com.software.peliculas.common.Constantes;
import exdrafts.com.software.peliculas.domain.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class AccesoDatosImpl implements IAccesoDatos {
    @Override
    public boolean comprobarSiExisteArchivo(String nombreRecurso) throws AccesoDatosExcepcion {
        File file = new File(nombreRecurso);
        return file.exists();
    }
    //En parte 3
    @Override
    public List<Pelicula> listaPeliculas(String nombreRecurso) throws LecturaDatosExcepcion {
        File file = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try (BufferedReader entrada = new BufferedReader(new FileReader(file))) {
            for (String contenido = entrada.readLine(); contenido != null; contenido = entrada.readLine()) {
                Pelicula pelicula = new Pelicula(contenido);
                peliculas.add(pelicula);
            }

        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion();
        }

        return peliculas;
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcepcion {
        File archivo = new File(nombreRecurso);
        boolean encontrado = false;
        String resultado = null;
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))){
            String linea;
            int indice; //declarar afuera para poner variables de distinto tipo en el for
            for (linea= entrada.readLine(), indice = 1; linea!=null && !encontrado; linea= entrada.readLine(),indice++){
                if(buscar!=null && buscar.strip().equalsIgnoreCase(linea)){
                    resultado= "Pelicula" + linea + "encontrada en el índice" + indice;
                    encontrado = true;
                }
            }
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosExcepcion();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        try (PrintWriter ignored = new PrintWriter(new FileWriter(archivo))){
            System.out.println(Constantes.SE_HA_CREADO_EL_ARCHIVO);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepcion();
        }
    }
    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosExcepcion {
        File archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            try {
                archivo.delete();
                System.out.println(Constantes.SE_HA_BORRADO_EL_ARCHIVO);
            } catch (SecurityException e) {
                e.printStackTrace(System.out);
                throw new AccesoDatosExcepcion("No se pudo borrar el archivo debido a un problema de acceso.");
            }
        } else {
            System.out.println(Constantes.EL_ARCHIVO_NO_EXISTE);
        }
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosExcepcion {
        File file = new File(nombreRecurso);
        try (PrintWriter salida = new PrintWriter(new FileWriter(file,anexar))){
            salida.print(pelicula);//llama a toString
            System.out.println(Constantes.SE_HA_ANADIDO_LA_PELICULA + pelicula);
        }catch (IOException e){
            e.printStackTrace(System.out);
            throw new EscrituraDatosExcepcion();
        }
    }
}
