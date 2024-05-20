package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Funcion funcion = new Funcion();
        funcion.getTeatros().forEach(System.out::println);

        System.out.println("Ingrese el nombre");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese la direccion");
        String dir = entrada.nextLine();

        Teatro teatro = funcion.devolverTeatro(nombre.strip(), dir);






        if (teatro == null) {
            System.out.println("No se encontro el teatro");
        } else {




            teatro.getSesiones().forEach(System.out::println);
            System.out.println("Ingrese el nombre de la sesion desea cambiar de nombre");
            String nombreSesion = entrada.nextLine();
            System.out.println("Ingrese el nuevo nombre");
            String nuevoNombre = entrada.nextLine();
            for (int i = 0; i <  teatro.getSesiones().size(); i++) {
                if (teatro.getSesiones().get(i).getNombre().equals(nombreSesion)) {
                    System.out.println("Ingrese el nuevo precio");
                    double nuevoPrecio = entrada.nextDouble();

                    if (funcion.cambiarPrecioNombreSesion( teatro.getSesiones().get(i), nuevoPrecio, nuevoNombre)) {
                        System.out.println("Se cambio el nombre de la sesion");
                    } else {
                        System.out.println("No se pudo cambiar el nombre de la sesion");
                    }
                }
            }


            System.out.println("Ingrese cuantas sesiones quiere ver");
            int sesiones = entrada.nextInt();
            entrada.nextLine();
            if (sesiones > teatro.getSesiones().size() || sesiones < 0) {
                System.out.println("No hay esa cantidad de sesiones");
            } else {
                List<Sesion> sesion = teatro.getSesiones();
                List<Sesion> sesionObtenida = new ArrayList<>();
                for (int i = 0; i < sesiones; i++) {
                    System.out.println("Ingrese el nombre de la sesion " + (i + 1));
                    nombreSesion = entrada.nextLine();
                    for (Sesion value : sesion) {
                        if (value.getNombre().equals(nombreSesion)) {
                            sesionObtenida.add(value);
                        }
                    }
                }
                System.out.println("Ingrese la butaca");
                int butaca = entrada.nextInt();
                if (!funcion.venderButaca(teatro, sesionObtenida, butaca)) {
                    System.out.println("No hay esa butaca");
                } else {
                    System.out.println("Se vendio la butaca");
                }
            }


        }

    }
}