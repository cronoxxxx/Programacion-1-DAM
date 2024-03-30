package EJERCICIOS.CLASESYOBJETOS.Inicial.E8;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese la altura del rectangulo");
        double base = entrada.nextDouble();
        System.out.println("Ingrese la base del rectangulo");
        double altura = entrada.nextDouble();
        System.out.println("Ingrese la ubicacion de eje vertical del rectangulo");
        double y = entrada.nextDouble();
        System.out.println("Ingrese la ubicacion de eje horizontal del rectangulo");
        double x = entrada.nextDouble();

        Rectangulo real = new Rectangulo(new Rectangulo(base,altura,x,y));
        int opcion;
        do {
            System.out.println("RECTANGULO");
            System.out.println("1. Asignar base y altura");
            System.out.println("2. Devolver copia");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1 ->{
                    System.out.println("Por cual metodo quiere asignar?");
                    System.out.println("1. Por base y altura en dos partes");
                    System.out.println("2. Por base y altura en un solo valor");
                    System.out.println("3. Que lo haga el programa");
                    System.out.println("Ingrese una opcion: ");
                    menuBaseAltura(entrada.nextInt(),real);
                }
                case 2 -> {
                    Rectangulo copia = real.devolver();
                    System.out.println("Copia del rectángulo:");
                    System.out.println(copia);
                }
                case 3 -> System.out.println("VUELVA PRONTO !!!");
                default -> System.err.println("Opcion no valida");
            }
        } while (opcion!=3);
    }

    private static void menuBaseAltura (int opcion,Rectangulo r){
        Scanner entrada= new Scanner(System.in);
        switch (opcion){
            case 1 -> {
                System.out.println("Ingrese la base ");
                double base = entrada.nextDouble();
                System.out.println("Ingrese la altura");
                double altura = entrada.nextDouble();
                if (r.agranda(base,altura)){
                    System.out.println("Agregado con exito");
                    System.out.println(r);
                } else {
                    System.out.println("Ha habido un error");
                }

            }
            case 2 -> {
                System.out.println("Ingrese la valor ");
                double valor = entrada.nextDouble();
                if (r.agranda(valor)){
                    System.out.println("Agregado con exito");
                    System.out.println(r);
                } else {
                    System.out.println("Ha habido un error");
                }
            }
            case 3 -> {
                if (r.agranda()){
                    System.out.println("Agregado con exito");
                    System.out.println(r);
                } else {
                    System.out.println("Ha habido un error");
                }
            }

        }
    }
}
