package org.example.domain;

import net.datafaker.Faker;
import org.example.common.Comprobacion;
import org.example.common.correoException;
import org.example.common.precioEntradaException;
import org.example.common.valoracionException;

import java.io.Serializable;
import java.time.LocalDate;

public class ParqueAtracciones extends CentrosOcio  {
    private int edadMinima;

    public ParqueAtracciones(int valoracion, String nombre, String provincia, String correoAtencion, LocalDate fechaAlta, double precioEntrada, int edadMinima) throws valoracionException, precioEntradaException, correoException {
        super(valoracion, nombre, provincia, correoAtencion, fechaAlta, precioEntrada);
        this.edadMinima = edadMinima;
        Comprobacion.precioEntradaParqueOK(this.precioEntrada);
        Comprobacion.valoracionOK(this.valoracion);
    }

    public ParqueAtracciones() {
        super();
        Faker faker = new Faker();
        this.edadMinima = faker.number().numberBetween(10, 100);
        this.precioEntrada= faker.number().numberBetween(15,25);
    }
    @Override
    public double precioEntradaReal(int edad,boolean isFestivo) {
        if (edad < this.edadMinima) {
            if (edad>65){
                return 0;
            } else if (isFestivo){
                return precioEntrada = precioEntrada + precioEntrada*0.4;
            } else {
                return precioEntrada;
            }
        }
            return -1;
    }

    public String toString() {
        return String.format("ID %d\nValoracion %s\nNombre %s\nProvincia %s\nCorreo Atencion %s\nFecha Alta %s\nPrecio Entrada %s\nEdad Minima %s", this.getId(), this.getValoracion(), this.getNombre(), this.getProvincia(), this.getCorreoAtencion(), this.getFechaAlta(), this.getPrecioEntrada(), edadMinima);
    }


}
