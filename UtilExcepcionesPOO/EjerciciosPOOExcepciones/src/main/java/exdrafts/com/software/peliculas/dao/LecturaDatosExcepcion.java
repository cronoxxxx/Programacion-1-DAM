package exdrafts.com.software.peliculas.dao;

public class LecturaDatosExcepcion extends  AccesoDatosExcepcion{
    public LecturaDatosExcepcion() {
        super("Error en la lectura de datos");
    }

    public LecturaDatosExcepcion(String message) {
        super(message);
    }
}
