package org.example.TryCatch;

import java.util.Scanner;

public class e1 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese un numero");
        try {
            if (entrada.hasNextInt()) {
                int var = entrada.nextInt();
                System.out.println("Variable: " + var);
            } else {
                throw new ErrorNumeral("No se acepta letras");
            }
        } catch (ErrorNumeral err) {
            System.out.println(err.getMessage());
        }
    }
}
