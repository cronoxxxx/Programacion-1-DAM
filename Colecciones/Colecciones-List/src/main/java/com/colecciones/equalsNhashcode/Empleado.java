package com.colecciones.equalsNhashcode;

import java.util.Objects;

public class Empleado {
    private String nombre,apellido,pais;
    private int edad;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo=sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
       return String.format("Nombre: %s\nEdad: %d\nSueldo %.2f\n",nombre,edad,sueldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return edad == empleado.edad && Double.compare(sueldo, empleado.sueldo) == 0 && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellido, empleado.apellido) && Objects.equals(pais, empleado.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, pais, edad, sueldo);
    }



}
