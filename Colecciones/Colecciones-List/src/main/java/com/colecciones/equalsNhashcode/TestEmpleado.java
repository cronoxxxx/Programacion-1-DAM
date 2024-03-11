package com.colecciones.equalsNhashcode;

public class TestEmpleado {
    public static void main(String[] args) {
        Empleado uno = new Empleado("Adrian",19,2000);
        Empleado dos = new Empleado("Adrian",19,2000);


        if (uno.equals(dos)){
            System.out.println("Tienen la misma referencia de memoria");
        } else {
            System.out.println("No tienen la misma referencia de memoria");
        }
        if (uno.hashCode()==dos.hashCode()){
            System.out.println("Los hash son iguales");
        } else {
            System.out.println("Los hash no son iguales");
        }


    }
}
