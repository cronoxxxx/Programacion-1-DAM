package EJERCICIOS.CLASESYOBJETOS.Inicial.E7;

public class Comprobacion {
    public static void saldoOK (double cantidad ) throws SaldoVacioException {
        if (cantidad==0 ||cantidad<0){
            throw new SaldoVacioException();
        }
    }
}
