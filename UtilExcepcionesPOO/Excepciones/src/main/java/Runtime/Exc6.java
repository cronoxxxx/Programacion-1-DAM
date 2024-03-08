package Runtime;

import java.util.*;

public class Exc6 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        try {
            System.out.println("Ingrese el 1er numero");
            int n1= entrada.nextInt();
            System.out.println("Ingrese el 1er numero");
            int n2= entrada.nextInt();
            try {
                int div = n1/n2;
                System.out.println("Resultado: "+div);
            } catch (ArithmeticException a){
                System.out.println("No se puede dividir entre 0, el error es:  "+a);
            }
        } catch (InputMismatchException a){
            System.out.println("No se aceptan valores de letras");
        } finally {
            System.out.println("Cerrando programa");
        }




            //La excepcion te indica donde te estas equivocando, no es un error


    }

}
