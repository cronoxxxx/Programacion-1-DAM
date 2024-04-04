package EJERCICIOS.CLASESYOBJETOS.Inicial.E16;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese la variable a");
        int a = entrada.nextInt();
        System.out.println("Ingrese la variable b");
        int b= entrada.nextInt();
        System.out.println("Ingrese la variable c");
        int c= entrada.nextInt();
        EcuacionCuadrada e = new EcuacionCuadrada(a,b,c);
        System.out.println("Valor del discriminante: "+df.format(e.getDiscriminante()));
        System.out.println("Soluciones posibles: "+e.cuantasSoluciones());
        e.mostrarSoluciones();
    }
}
