package com.colecciones.listas.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tester {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("John","Travolta","EE.UU",50,50000));
        listaEmpleados.add(new Empleado("Adrian","Saavedra","Venezuela",19,5000));


        System.out.println("COMPARABLE: ");
        Collections.sort(listaEmpleados);
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }
//EN REVERSA
        Collections.reverse(listaEmpleados);
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }



    }
}
