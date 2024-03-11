package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trycatch {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        boolean valido;
        do {
            int var;
            System.out.println("Ingresa un numero");
            try {
                var = entrada.nextInt();
                System.out.println("Variable : "+var);
                    valido=false;
            } catch (InputMismatchException im){
                System.out.println("Ponme un numero maldito negro");
                im.printStackTrace(System.out);
                valido=true;
                entrada.next();
            }

        } while (valido);




    }
}
