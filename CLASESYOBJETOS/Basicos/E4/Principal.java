package EJERCICIOS.CLASESYOBJETOS.Basicos.E4;

import java.util.Scanner;

/*Crear la clase Vivienda. Atributos públicos String calle, int numero, double precio, int superficie, boolean
conGarage. Crear al menos dos constructors y ademas uno por defecto. Hacer programa Principal, con
un método main donde se creen objetos de la clase con todos los constructores, y consultar sus
atributos por consola*/
public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        String calle;
        int numero,superficie;
        double precio;
        Vivienda nueva;
        System.out.println("¿Que vivienda desea consultar?\n" +
                "1. Con garaje\n" +
                "2. Sin garaje\n" +
                "3. SALIR");
        int opcion= entrada.nextInt();
        entrada.nextLine();
        switch (opcion){
            case 1:
                System.out.println("Ingrese la calle");
                calle=entrada.nextLine();
                System.out.println("Ingrese el numero");
                numero= entrada.nextInt();
                System.out.println("Ingrese la superficie");
                superficie= entrada.nextInt();
                System.out.println("Ingrese el precio");
                precio= entrada.nextDouble();
                nueva=new Vivienda(calle,numero,superficie,precio);
                System.out.println("Calle: "+nueva.calle);
                System.out.println("Numero: "+nueva.numero);
                System.out.println("Superficie: "+nueva.superficie);
                System.out.println("Precio: "+nueva.precio);

                break;
            case 2:
                System.out.println("Ingrese la calle");
                calle=entrada.nextLine();
                System.out.println("Ingrese el numero");
                numero= entrada.nextInt();
                System.out.println("Ingrese la superficie");
                superficie= entrada.nextInt();
                System.out.println("Ingrese el precio");
                precio= entrada.nextDouble();
                nueva=new Vivienda(calle,numero,precio,superficie);
                System.out.println("Calle: "+nueva.calle);
                System.out.println("Numero: "+nueva.numero);
                System.out.println("Superficie: "+nueva.superficie);
                System.out.println("Precio: "+nueva.precio);

                break;
            case 3:
                new Vivienda();
                break;

            default:
                System.out.println("Opcion no existente");
        }

    }
}
