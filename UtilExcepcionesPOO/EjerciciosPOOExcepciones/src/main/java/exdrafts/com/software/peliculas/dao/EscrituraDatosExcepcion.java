package exdrafts.com.software.peliculas.dao;

public class EscrituraDatosExcepcion extends  AccesoDatosExcepcion{
    public EscrituraDatosExcepcion() {
        super("Error en la escritura de datos");
    }

    public EscrituraDatosExcepcion(String message) {
        super(message);
    }
}
