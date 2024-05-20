package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

@Data@Getter@Setter
public class Sesion {
    private String nombre;
    private double precio;

    public Sesion(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Sesion () {
        Faker faker = new Faker();
        this.nombre = faker.book().title();
        this.precio = faker.number().numberBetween(10, 50);
    }


}
