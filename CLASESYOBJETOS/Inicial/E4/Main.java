package EJERCICIOS.CLASESYOBJETOS.Inicial.E4;

import java.util.Scanner;

public class Main {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        Persona promedio;
        System.out.println("Ingrese el nombre de la persona: ");
        String nombre=entrada.nextLine();
        System.out.println("Ingrese su DNI/NIE");
        String DNI= entrada.nextLine();
        System.out.println("Ingrese su edad");
        int edad;
        do {
            edad= entrada.nextInt();
            entrada.nextLine();
            if (edad<0){
                System.err.println("Edad no valida");
            }
            if (edad>=0){
                promedio=new Persona(nombre,DNI,edad);
                promedio.esMayorDeEdad();
                int mayorEdad= promedio.cuantoHaceMayorEdad();
                if (mayorEdad==-1){
                    System.out.println("No es una persona mayor de edad");
                } else {
                    System.out.println("Su edad es: "+mayorEdad);
                }
                boolean DNIasignado;
                do {
                    DNIasignado= promedio.asignarDNI(DNI);
                    if (!DNIasignado){
                        System.err.println("No se puede asignar DNI porque no cumple con la longitud, ingrese de nuevo");
                        DNI= entrada.nextLine();
                    } else {
                        System.out.println("DNI asignado: "+promedio.getDNI());
                    }
                }while (!DNIasignado);
                boolean jubilacion=promedio.estaJubilado();
                if (jubilacion){
                    System.out.println("Es una persona jubilada");
                } else {
                    System.out.println("No es una persona jubilada");
                }
            }else {
                System.out.println("No se puede realizar la accion");
            }
        } while (edad<0);

    }
}
