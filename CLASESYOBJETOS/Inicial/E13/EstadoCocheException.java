package EJERCICIOS.CLASESYOBJETOS.Inicial.E13;

public class EstadoCocheException extends Exception{
    public EstadoCocheException() {super("El estado de coche no coincide con ninguna de las opciones de alquilado o no alquilado");
    }

    public EstadoCocheException(String message) {
        super(message);
    }
}
