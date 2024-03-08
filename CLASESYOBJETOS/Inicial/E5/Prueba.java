package EJERCICIOS.CLASESYOBJETOS.Inicial.E5;

import java.util.Scanner;

public class Prueba {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        Coche[] coche = new Coche[3];
        String respuesta;
        String color,matricula;
        for (int i = 0; i < coche.length; i++) {
            System.out.println("COCHE "+(i+1)+":");
            do {
                System.out.println("Desea cambiar el color del coche? (si/no)");
                respuesta=entrada.nextLine();
                if (respuesta.trim().equalsIgnoreCase("si")){
                    color="Blanco";
                } else if(respuesta.trim().equalsIgnoreCase("no")){
                    System.out.println("Ingrese el nuevo color del coche");
                    color= entrada.nextLine();
                } else {
                    System.err.println("Respuesta no valida");
                }
            }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));
            System.out.println("Ingrese la matricula");
            matricula= entrada.nextLine();


        }
    }
    public static void mediaPrecio(Coche []coche){

    }
}
