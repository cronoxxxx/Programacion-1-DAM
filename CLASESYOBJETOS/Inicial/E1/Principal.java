package EJERCICIOS.CLASESYOBJETOS.Inicial.E1;

import java.util.Scanner;

public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Triangulo: ");
        int opcion,base,altura;
        int lado1,lado2;
        Triangulo nuevo;
        do {
            System.out.println("1.Hallar Perimetro\n" +
                    "2.Hallar Area");
            System.out.println("Seleccione una opcion");
            opcion=entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese la base del triangulo");
                    base= entrada.nextInt();
                    nuevo = new Triangulo(base);
                    System.out.println("Ingrese el primer lado del triangulo: ");
                    lado1=entrada.nextInt();
                    System.out.println("Ingrese el segundo lado del triangulo");
                    lado2= entrada.nextInt();
                    int perimetroHallada= nuevo.getPerimetro(lado1,lado2);
                    System.out.println("El perimetro es: "+perimetroHallada);
                    break;
                case 2:
                    System.out.println("Ingrese la base del triangulo");
                    base= entrada.nextInt();
                    System.out.println("Ingrese la altura del triangulo");
                    altura= entrada.nextInt();
                    nuevo = new Triangulo(base,altura);
                    int areaHallada= nuevo.getArea();
                    System.out.println("El perimetro es: "+areaHallada);
                    break;
                case 3:
                    System.out.println("VUELVA PRONTO ! ! !");
                default:
                    System.err.println("Esa opcion no existe");
            }
        } while (opcion!=3);


    }
}
