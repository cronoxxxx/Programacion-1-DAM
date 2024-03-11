package com.colecciones.listas.comparador;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("John","Travolta","EE.UU",50,50000));
        listaEmpleados.add(new Empleado("Adrian","Saavedra","Venezuela",19,5000));


        System.out.println("COMPARATOR: ");
        //Collections.sort(listaEmpleados,new ComparatorEmpleado());
        Comparator<Empleado> comparador = new ComparatorEmpleado();
        listaEmpleados.sort(comparador);
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }

        //EN REVERSA
        comparador = new ComparatorEmpleado();
        listaEmpleados.sort(Collections.reverseOrder(comparador));
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }



    }
}
