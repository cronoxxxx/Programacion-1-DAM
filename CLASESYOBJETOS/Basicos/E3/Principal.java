package EJERCICIOS.CLASESYOBJETOS.Basicos.E3;

import java.util.Scanner;

/*
*
* Idem casos anteriores, pero con constructores con todos los atributos. Crear objetos y consultar
*
* */
public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Elige una opcion\n" +
                "1.Papel\n" +
                "2.Mascara");
        String color,personaje;
        boolean tienePelo;
        String pelo;
        int grosor;
        Idem papel;
        Idem personajes;
        int opcion= entrada.nextInt();
        entrada.nextLine();
        switch (opcion){
            case 1:
                System.out.println("Ingresa el color: ");
                color= entrada.nextLine();
                System.out.println("Ingresa su grosor");
                grosor= entrada.nextInt();
                papel= new Idem(color,grosor);
                System.out.println("Color: "+papel.color);
                System.out.println("Grosor: "+papel.grosor);
                break;
            case 2:
                System.out.println("Ingrese el nombre del personaje");
                personaje= entrada.nextLine();
                System.out.println("Tiene cabello? (s/n)");
                pelo= entrada.nextLine();
                if (pelo.equalsIgnoreCase("si") || pelo.equalsIgnoreCase("s")){
                    tienePelo=true;
                } else {
                    tienePelo=false;
                }
                personajes=new Idem(personaje,tienePelo);
                System.out.println("Nombre: "+personajes.personaje);
                if (personajes.tienePelo){
                    System.out.println("Tiene pelo");
                } else {
                    System.err.println("No tiene pelo");
                }
                break;
            default:
        }
    }
}
