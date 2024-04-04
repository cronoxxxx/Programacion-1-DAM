package EJERCICIOS.CLASESYOBJETOS.Inicial.E17;

public class CalificacionException extends Exception {
    public CalificacionException() {
        super("Va fuera del limite");
    }

    public CalificacionException(String message) {
        super(message);
    }
}
