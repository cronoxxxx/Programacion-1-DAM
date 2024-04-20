package org.example.HashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tester {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Adrian", "Saavedra", "Peru", 19, 2000));
        empleados.add(new Empleado("Mirko", "Saavedra", "Peru", 19, 12));
        if (empleados.get(0).equals(empleados.get(1))){
            System.out.println("True");
        } else{
            System.out.println("False");
        }

        if (empleados.get(0).hashCode()==empleados.get(1).hashCode()){
            System.out.println("True");
        } else{
            System.out.println("False");
        }



    }
}
