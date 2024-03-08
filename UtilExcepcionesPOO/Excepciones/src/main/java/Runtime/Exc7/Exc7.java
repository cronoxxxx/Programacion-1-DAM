package Runtime.Exc7;

import java.util.Scanner;

public class Exc7 {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Ingrese numerador");
        int n1= entrada.nextInt();
        System.out.println("Ingrese denominador");
        int n2 = entrada.nextInt();
        int result = 0;
        try {
            result= aritmetica.dividir(n1,n2);
        } catch (OperacionAritmetica e){
            e.printStackTrace(System.out);
        } finally {
            System.out.println("Fin del programa");
        }

        System.out.println("Resultado: "+ result);

        }
    }

