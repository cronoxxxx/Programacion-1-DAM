package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

import java.io.Serializable;
@Getter@Setter
public abstract class Pista implements Serializable{
    protected int id;
    protected String nombre, provincia;
    protected double kmExtension;
    private static int autonumerico = 0;

    public Pista(int id, String nombre, String provincia, double kmExtension) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.kmExtension = kmExtension;
    }

    public Pista() {
        Faker f = new Faker();
        autonumerico++;
        this.id = autonumerico;
        this.nombre = f.book().title();
        this.provincia = f.address().cityName();
        this.kmExtension = Math.random() * 100;
    }

    public Pista(String nombre, String provincia, double kmExtension) {
        autonumerico++;
        this.id = autonumerico;
        this.nombre = nombre;
        this.provincia = provincia;
        this.kmExtension = kmExtension;
    }
}