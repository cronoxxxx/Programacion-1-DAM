package EJERCICIOS.CLASESYOBJETOS.Inicial.E13;

public class CategoriaCocheException extends Exception{
    public CategoriaCocheException() {super("Solo es valido entre 1 y 2");
    }

    public CategoriaCocheException(String message) {
        super(message);
    }
}
