package EJERCICIOS.CLASESYOBJETOS.Basicos.E2;

import java.util.Scanner;

/*
*
* Crear una clase Mascara. Atributos públicos String personaje, boolean tienePelo. Hacer programa Principal,
con un método main donde se creen objetos de la clase, con constructor por defecto, dar valor a los
atributos y consultarlos por consola
*
* */
public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre del personaje de la mascara");
        String personaje= entrada.nextLine();
        System.out.println("¿Tiene pelo? (solo true/false)");
        boolean tienePelo=entrada.nextBoolean();
        Mascara mascara= new Mascara(personaje,tienePelo);
        System.out.println("Personaje: "+mascara.personaje);
        if (mascara.tienePelo){
            System.out.println("Tiene cabello");
        } else {
            System.out.println("No tiene cabello");
        }
    }
}
