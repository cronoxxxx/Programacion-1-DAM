package EJERCICIOS.CLASESYOBJETOS.Inicial.E18;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese un texto");
        String str = entrada.nextLine();
        MiString m = new MiString(str);
        System.out.println(m.mitadFrase());
        System.out.println(m.mitadFrases());
        System.out.println(m.invierteFrase());
        System.out.println(m.invierteFrases());
        System.out.println(m.concat("panza"));
        System.out.println(m.concat("panza"));
        System.out.println(m.tamaño());
        System.out.println(m.tamañosinEspacios());

    }
}
