package EJERCICIOS.CLASESYOBJETOS.Inicial.E7;

public class SaldoVacioException extends Exception{
    public SaldoVacioException() {
        super("No se pueden agregar valores negativos");
    }

    public SaldoVacioException(String message) {
        super(message);
    }
}
