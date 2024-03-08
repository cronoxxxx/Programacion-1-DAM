package EJERCICIOS.CLASESYOBJETOS.Basicos.E6;

import java.util.Scanner;

public class Principal {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args) {
        Chalet casa;
        System.out.println("Ingrese la calle");
        String calle=entrada.nextLine();
        System.out.println("Ingrese el numero de parcela: ");
        short numParcela;
        do {
            numParcela= entrada.nextShort();
            if (numParcela<1 || numParcela>10){
                System.err.println("El numero de parcela es menor que 1 o mayor que 10");
            }
        } while (numParcela<1 || numParcela>10);
        System.out.println("Ingrese el precio: ");
        double precio;
        do {
            precio= entrada.nextDouble();
            if (precio<0){
                System.err.println("Precio negativo");
            }
        }while (precio<0);
        System.out.println("Ingrese la superficie: ");
        int superficie;
        do {
            superficie= entrada.nextInt();
            if (superficie<0 || superficie>2000){
                System.err.println("Superficie negativa o mayor que 2000");
            }
        }while (superficie<0 || superficie>2000);
        entrada.nextLine();
        System.out.println("¿Tiene piscina? (si/no)");
        String respuesta = entrada.nextLine();
        if (respuesta.equalsIgnoreCase("si")){
            casa= new Chalet(calle,numParcela,precio,superficie);
            casa.setNumParcela(numParcela);
            casa.setCalle(calle);
            casa.setPrecio(precio);
            casa.setSuperficie(superficie);
            System.out.println("Numero de parcela: "+casa.getNumParcela());
            System.out.println("Numero de calle: "+casa.getCalle());
            System.out.println("Precio: "+casa.getPrecio());
            System.out.println("Superficie:"+casa.getSuperficie());
            System.out.println("Tiene piscina: "+casa.isConPiscina());
        } else if (respuesta.equalsIgnoreCase("no")){
            casa= new Chalet(calle,numParcela,superficie,precio);
            casa.setNumParcela(numParcela);
            casa.setCalle(calle);
            casa.setPrecio(precio);
            casa.setSuperficie(superficie);
            System.out.println("Numero de parcela: "+casa.getNumParcela());
            System.out.println("Numero de calle: "+casa.getCalle());
            System.out.println("Precio: "+casa.getPrecio());
            System.out.println("Superficie:"+casa.getSuperficie());
            System.out.println("Tiene piscina: "+casa.isConPiscina());
        } else {
            System.out.println("Esa opcion no existe");
        }
    }
}
