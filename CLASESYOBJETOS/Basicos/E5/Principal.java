package EJERCICIOS.CLASESYOBJETOS.Basicos.E5;

import java.util.Scanner;

public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ingrese el nombre");
        String nombre= entrada.nextLine();
        System.out.println("¿Abandonaste la asignatura? (si/no)");
        String estado=entrada.nextLine();
        Asignatura cualquiera;
        if (estado.equalsIgnoreCase("si")){
            cualquiera=new Asignatura(nombre);
            System.out.println(cualquiera);
        } else if (estado.equalsIgnoreCase("no")){
            System.out.println("Ingrese la cantidad de creditos: ");
            double creditos= entrada.nextInt();
            if (creditos>0.1 && creditos<=10){
                cualquiera=new Asignatura(creditos,nombre);
                System.out.println(cualquiera);
            } else {
                System.out.println("No existe esa cantidad de creditos");
            }
        } else {
            System.err.println("Esa opcion no existe");
        }
    }
}
