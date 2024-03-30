package EJERCICIOS.CLASESYOBJETOS.Inicial.E10;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        double [] scores = new double[3];
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < scores.length; i++) {
            scores[i] = Double.parseDouble(df.format((Math.random() * 10) + 1).replace(",", "."));
        }
        Alumno nuevo = new Alumno("Adrian");
        nuevo.setNotas(scores);
        System.out.println(nuevo);

        System.out.println("Ingrese la evaluacion a la que quiere poner nota: ");
        int eval = entrada.nextInt();
        System.out.println("Ingrese la nota: ");
        double nota = entrada.nextDouble();
        if(nuevo.ponerNota(eval,nota)){
            System.out.println("Agregado con exito");
            System.out.println(nuevo);
        } else {
            System.err.println("No se pudo realizar la operacion");
        }
        System.out.println("Ingrese una evaluacion y borramos la nota: ");
        eval = entrada.nextInt();
        if(nuevo.borrarNota(eval)){
            System.out.println("Borrado con exito");
            System.out.println(nuevo);
        } else {
            System.err.println("No se pudo realizar la operacion");
        }

        System.out.println("Numero de notas: "+nuevo.numeroNotas());
        if (nuevo.notaMaxima()!=1){
            System.out.println("Nota maxima: "+nuevo.notaMaxima());
        } else {
            System.err.println("No se pudo hallar la maxima nota");
        }
        System.out.println("Ingresa la evaluacion para obtener su nota: ");
        eval = entrada.nextInt();
        if (nuevo.getNotaEvaluacion(eval)!=1){
            System.out.println("Note de la evaluacion "+eval+": "+nuevo.getNotaEvaluacion(eval));
        } else {
            System.out.println("La nota esta vacia");
        }
        if (nuevo.tieneNota(eval)){
            System.out.println("Hay nota");
        } else {
            System.out.println("No hay nota");
        }
    }
}
