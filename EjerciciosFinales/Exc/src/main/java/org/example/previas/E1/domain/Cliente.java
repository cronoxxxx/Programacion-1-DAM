package org.example.previas.E1.domain;

import net.datafaker.Faker;

import java.io.Serializable;

public abstract class Cliente implements Serializable {
    protected String nombre,apellidos;
    protected boolean hasDescuento;
    public Cliente(String nombre, String apellidos, boolean hasDescuento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.hasDescuento = hasDescuento;
    }

    public boolean isHasDescuento() {
        return hasDescuento;
    }

    public void setHasDescuento(boolean hasDescuento) {
        this.hasDescuento = hasDescuento;
    }

    public Cliente() {
        Faker f = new Faker();
        this.nombre = f.name().firstName();
        this.apellidos = f.name().lastName();
        hasDescuento = (int) (Math.random() * 2) == 1; //si se evalua a 1, sale verdadero
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
