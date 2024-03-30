package EJERCICIOS.CLASESYOBJETOS.Inicial.E11;

import java.util.Scanner;

public class TestMovil {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese la capcaidad maxima del movil en megas");
        int capacidadMax = entrada.nextInt();
        System.out.println("Ingrese el numero maximo de aplicaciones permitidos en el movil ");
        int appsMax = entrada.nextInt();
        try {
            Movil n1 = new Movil(capacidadMax,appsMax);
            System.out.println("Ingrese el peso de la aplicacion a añadir");
            int capacidadApp = entrada.nextInt();
            if(n1.añadirAplicacion(capacidadApp)){
                System.out.println("Se ha añadido un aplicacion con "+capacidadApp+" MB");
                System.out.println(n1);
            } else {
                System.err.println("No se pudo completar la accion");
            }
            entrada.nextLine();
            System.out.println("Deseas borrar todo? (si/no)");
            String resp = entrada.nextLine();
            if (resp.strip().equalsIgnoreCase("si")){
                n1.borrarTodo();
                System.out.println(n1);
            } else if (resp.strip().equalsIgnoreCase("no")) {
                System.out.println(n1);
            }
        } catch (MBEXception e) {
            entrada.nextLine();
            System.out.println(e.getMessage());
        }
    }
}
