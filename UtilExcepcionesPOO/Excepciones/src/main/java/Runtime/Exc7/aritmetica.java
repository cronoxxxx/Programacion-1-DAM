package Runtime.Exc7;

public class aritmetica {
    public static int dividir (int numerador, int denominador){
        if (denominador==0){
            throw new OperacionAritmetica("No se aceptan ceros de denominador");
        }
        return numerador/denominador;
    }

}
