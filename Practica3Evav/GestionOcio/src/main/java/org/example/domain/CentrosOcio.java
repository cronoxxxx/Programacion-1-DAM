package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.example.common.Comprobacion;
import org.example.common.correoException;
import org.example.common.precioEntradaException;
import org.example.common.valoracionException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter@Setter
public abstract class CentrosOcio implements Serializable {
    protected int id,valoracion;
    private static int autoIncrement = 0;
    protected String nombre,provincia;
    protected String correoAtencion;
    protected LocalDate fechaAlta;
    protected double precioEntrada;

    public CentrosOcio(int valoracion, String nombre, String provincia, String correoAtencion, LocalDate fechaAlta, double precioEntrada) throws precioEntradaException, valoracionException, correoException {
        autoIncrement++;
        this.id = autoIncrement;
        this.valoracion = valoracion;
        this.nombre = nombre;
        this.provincia = provincia;
        this.correoAtencion = correoAtencion;
        this.fechaAlta = fechaAlta;
        this.precioEntrada = precioEntrada;
        Comprobacion.correoOK(this.correoAtencion);
    }

    public CentrosOcio() {
        Faker faker = new Faker();
        autoIncrement++;
        this.id = autoIncrement;
        this.fechaAlta= LocalDate.now().minusDays(10).minusDays(faker.number().numberBetween(1, 10));
        this.precioEntrada = 0;
        this.valoracion = faker.number().numberBetween(1, 5);
        this.nombre = faker.company().name();
        this.provincia = faker.address().state();
        this.correoAtencion = faker.internet().emailAddress();
    }

    public abstract double precioEntradaReal(int edad,boolean isFestivo);


}
