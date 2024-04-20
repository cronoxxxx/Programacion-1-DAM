package org.example.previas.E1.domain;

import net.datafaker.Faker;

import java.io.Serializable;

public abstract class Cliente implements Serializable {
    protected String nombre;
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente() {
        Faker f = new Faker();
        this.nombre = f.name().fullName();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
