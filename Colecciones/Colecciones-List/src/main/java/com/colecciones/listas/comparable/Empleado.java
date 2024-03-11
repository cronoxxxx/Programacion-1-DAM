package com.colecciones.listas.comparable;

public class Empleado implements Comparable<Empleado>  {
    private String nombre,apellido,pais;
    private int edad;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String pais, int edad, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
       return String.format("Nombre: %s\nApellido: %s\nPais: %s\nEdad: %d\nSueldo %.2f\n",nombre,apellido,pais,edad,sueldo);
    }
    @Override
    public int compareTo(Empleado asignado) {
        //return this.edad-asignado.getEdad(); //comparar edades
        return this.pais.compareTo(asignado.getPais());
    }
}
