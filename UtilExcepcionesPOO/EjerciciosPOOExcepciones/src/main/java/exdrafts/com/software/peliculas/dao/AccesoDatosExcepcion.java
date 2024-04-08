package exdrafts.com.software.peliculas.dao;

public class AccesoDatosExcepcion extends Exception{
    public AccesoDatosExcepcion() {
        super("Error en el acceso de datos");
    }

    public AccesoDatosExcepcion(String message) {
        super(message);
    }
}
