package Runtime.Exc5;

import java.util.Scanner;

public class Exc5 {
    private static int numero;
    private static Scanner entrada= new Scanner(System.in);
    public static void introducirNumero() throws Excepcion0 {
        do {
            System.out.println("Ingrese un numero");
            numero= entrada.nextInt();
            if (numero==0){
                throw new Excepcion0();
            }
        }while (numero!=0);
    }

    public static void main(String[] args) {
        try {
            introducirNumero();
        }catch (Excepcion0 cero){
            System.out.println("Cero atrapado");
        }
    }


}
