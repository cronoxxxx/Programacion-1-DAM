package org.example.Comparadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Collections.sort;


public class Tester {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Empleado> lista = new ArrayList<>();
        /*IntStream.range(0, 2).forEach(i -> {

            lista.add(crearEmpleado());
        });*/
        IntStream.range(0, 2).mapToObj(i -> {
            System.out.println("Nombre" + i);
            String nombre = entrada.next();
            System.out.println("Apellido" + i);
            String apellido = entrada.next();
            System.out.println("Pais" + i);
            String pais = entrada.next();
            System.out.println("Edad" + i);
            int edad = entrada.nextInt();
            System.out.println("Sueldo" + i);
            double sueldo = entrada.nextDouble();
            return new Empleado(nombre, apellido, pais, edad, sueldo);
        }).forEach(lista::add);
        //Comparator para edad en orden
        lista.sort(new ComparatorEmpleado());
        System.out.println(lista);
        //Comparator para edad en reversa
        lista.sort(new ComparatorEmpleado().reversed());
        System.out.println(lista);

        //Comparable para edad en orden
        Collections.sort(lista);
        System.out.println(lista);
        //Comparable para edad en reserva

        Collections.reverse(lista);
        System.out.println(lista);

    }
    /*private static Empleado crearEmpleado() {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Nombre");
        String nombre = entrada.next();
        System.out.println("Apellido");
        String apellido = entrada.next();
        System.out.println("Pais");
        String pais = entrada.next();
        System.out.println("Edad");
        int edad = entrada.nextInt();
        System.out.println("Sueldo");
        double sueldo = entrada.nextDouble();
        return new Empleado(nombre, apellido, pais, edad, sueldo);
    }*/

}


