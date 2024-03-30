package EJERCICIOS.CLASESYOBJETOS.Inicial.E62;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese hora: ");
        int hora= entrada.nextInt();
        System.out.println("Ingrese minuto: ");
        int min= entrada.nextInt();
        System.out.println("Ingrese segundo: ");
        int sec= entrada.nextInt();
        Reloj r = new Reloj(hora,min,sec);
        int opcion,segundos;
        do {
            System.out.println("Ingrese un opcion:\n1. Adelantar reloj\n2. Retroceder reloj\n3. Salir");
            System.out.println("Ingrese una opción: ");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.println("Ingrese la cantidad de segundos a adelantar: ");
                    segundos= entrada.nextInt();
                    if (r.adelantarReloj(segundos)){
                        r.imprimirHora();
                    } else {
                        System.err.println("No se pudo adelantar la hora");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese la cantidad de segundos a retroceder: ");
                    segundos= entrada.nextInt();
                    if (r.retrocederReloj(segundos)){
                        r.imprimirHora();
                    } else {
                        System.err.println("No se pudo adelantar la hora");
                    }
                }
                case 3 -> System.out.println("hasta pronto");
            }
        }while (opcion!=3);
    }
}
