package org.example.Muñecos;

public class Muñecos {
    private String nombre, tipo, trabajo, color;

    public Muñecos(String nombre, String tipo, String trabajo, String color) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.trabajo = trabajo;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void muñecoHabla(){
        System.out.println("Hola soy el muñeco de mirko, me llamo "+nombre);
    }

    public void muñecoMueve(){
        System.out.println("Hola soy un muñeco que se mueve, soy "+nombre+" y la paso pipa");
    }

    public String cambiaColor(String nuevoColor){
        return this.color = nuevoColor;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nTipo: %s\nTrabajo: %s\nColor: %s",
                nombre, tipo, trabajo, color);
    }


}
