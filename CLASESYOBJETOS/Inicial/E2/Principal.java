package EJERCICIOS.CLASESYOBJETOS.Inicial.E2;


import java.util.Scanner;

public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("MOTO\nSelecciona una opcion");
        int opcion;
        double cantidad;

        do {
            System.out.println("1. Aumentar velocidad");
            System.out.println("2. Frenar velocidad");
            System.out.println("Ingrese la opcion");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese la cantidad a aumentar");
                    cantidad= entrada.nextDouble();
                    boolean esAcelerado=Moto.aumentarVelocidad(cantidad);
                    if (esAcelerado){
                        System.out.println("Cantidad aumentada: "+Moto.getVelocidad());
                    } else {
                        System.out.println("Se tiene que aumentar, no disminuir");
                    }

                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a aumentar");
                    cantidad= entrada.nextDouble();
                    boolean esFrenado= Moto.frenar(cantidad);
                    if (esFrenado){
                        System.out.println("Cantidad disminuida: "+Moto.getVelocidad());
                    } else {
                        System.out.println("La velocidad tiene que ser mayor a 0");
                    }
                    break;
                case 3:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
                default:
                    System.err.println("Esa opcion no existe");
            }
        }while (opcion!=3);
    }
}
