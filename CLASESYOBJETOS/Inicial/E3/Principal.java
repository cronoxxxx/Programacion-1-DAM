package EJERCICIOS.CLASESYOBJETOS.Inicial.E3;

import java.util.Scanner;

/*Implementar una clase satélite para la que se guardan en tres valores double el paralelo y meridiano en
los que está el satélite y su distancia a la tierra. Implementar dos métodos, uno para cambiar de
posición al satélite y otro para escribir en pantalla su posición.*/
public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Cambiar posicion de satelite: ");
        int opcion;
        double incrementoM,incrementoP;
        boolean esValido;

        Satelite space=new Satelite(100,100);
        do {
            System.out.println("1. Cambiar paralelo");
            System.out.println("2. Cambiar meridiano");
            System.out.println("3. SALIR");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese posicion a cambiar");
                    incrementoP=entrada.nextDouble();
                    esValido=space.cambiarPosicionParalelo(incrementoP);
                    if (esValido){
                        System.out.println("Posicion actual: ("+space.getParalelo()+","+space.getMeridiano()+")");
                    } else if (space.getParalelo()+incrementoP<=-100){
                        System.out.println("Su posicion es menor a 100, podría chocar contra la tierra, por lo que es rechazado");
                    } else if (space.getParalelo()+incrementoP>=10000){
                        System.out.println("Posicion mayor a 10000, se va a ir lejos");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese posicion a cambiar");
                    incrementoM=entrada.nextDouble();
                    esValido=space.cambiarPosicionMeridiano(incrementoM);
                    if (esValido){
                        System.out.println("Posicion actual: ("+space.getParalelo()+","+space.getMeridiano()+")");
                    } else if (space.getMeridiano()+incrementoM<=-100){
                        System.out.println("Su posicion es menor a 100, podría chocar contra la tierra, por lo que es rechazado");
                    } else if (space.getMeridiano()+incrementoM>=10000){
                        System.out.println("Posicion mayor a 10000, se va a ir lejos");
                    }
                    break;
                case 3:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
                default:
                    System.err.println("Opcion no existente");
            }
        }while (opcion!=3);
    }



}
