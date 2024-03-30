package EJERCICIOS.CLASESYOBJETOS.Inicial.E11;

public class ComprobacionMegas {
    public static void megasOK (int megas) throws MBEXception {
        if (megas>=600000){
            throw new MBEXception();
        }
    }
}
