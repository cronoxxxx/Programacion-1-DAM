package org.example;

import lombok.Data;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Teatro {
private String nombre;
private final String direccion;
private List<Sesion> sesiones;
private int [][]butacas;

    public Teatro(String nombre, String direccion, List<Sesion> sesiones) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sesiones = new ArrayList<>();
        this.sesiones.addAll(sesiones);
        this.butacas = new int[6][10];
        Arrays.stream(butacas).forEach(butaca -> Arrays.fill(butaca, 0));
    }

    public Teatro(){
        Faker faker = new Faker();
        this.nombre = faker.book().title();
        this.direccion = faker.address().streetAddress();
        this.sesiones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sesiones.add(new Sesion());
        }
        this.butacas = new int[6][10];
        Arrays.stream(butacas).forEach(butaca -> Arrays.fill(butaca, 0));
    }


    @Override
    public String toString() {

        return String.format("Nombre: %s || Direccion: %s || Sesiones: %s", this.getNombre(), this.getDireccion(), this.getSesiones().toString());
    }
}
