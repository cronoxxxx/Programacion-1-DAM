package EJERCICIOS.CLASESYOBJETOS.Inicial.E11;

public class MBEXception extends Exception {
    public MBEXception() {
        super("No se aceptan megas inexistentes (a partir de 600 mil)");
    }

    public MBEXception(String message) {
        super(message);
    }
}
