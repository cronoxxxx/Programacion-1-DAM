package EJERCICIOS.CLASESYOBJETOS.Inicial.E2;
/*
* Implementar una clase Moto para que la guardamos la velocidad. Tendremos dos métodos uno para
acelerar (aumentamos su velocidad en una cantidad variable) y otro para frenar (disminuimos la
velocidad en una cantidad variable). Generar una clase con un main y crear una moto, y acelerarla y
frenarla para probar la clase
*
*
* */
public class Moto {
    private static double velocidad=0;


    public static boolean aumentarVelocidad(double incrementar){
        double velocidadAux= velocidad+incrementar;
        boolean respuesta=true;
        if (incrementar<=0){
            respuesta=false;
        } else{
            velocidad=velocidadAux;
        }
        return respuesta;
    }

    public static double getVelocidad() {
        return velocidad;
    }

    public static boolean frenar(double decrementar){
        double velocidadAux = velocidad-decrementar;
        boolean respuesta = true;

        if (velocidadAux>=0){
            velocidad=velocidadAux;
        } else {
            respuesta = false;
        }
        return respuesta;
    }



}
