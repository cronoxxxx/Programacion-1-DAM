package EJERCICIOS.CLASESYOBJETOS.Basicos.E1;

import java.util.Scanner;

/*Crear una clase Papel. Atributos públicos String color, int grosor. Hacer programa Principal, con un
método main donde se creen objetos de la clase Papel (con constructor por defecto), dar valor a los
atributos y consultarlos por consola*/
public class Main {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        Papel papel;
        System.out.println("Ingrese el color del papel");
        String color= entrada.nextLine();
        System.out.println("Ingrese el grosor del papel");
        int grosor = entrada.nextInt();
        papel = new Papel(color,grosor);
        System.out.println("Color: "+papel.color);
        System.out.println("Grosor: "+papel.grosor);

    }
}
