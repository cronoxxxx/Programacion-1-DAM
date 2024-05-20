package org.example.domain;

import net.datafaker.Faker;
import org.example.common.Comprobacion;
import org.example.common.correoException;
import org.example.common.precioEntradaException;
import org.example.common.valoracionException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Zoologico extends CentrosOcio {
    private List<String> servicios;

    public Zoologico(int valoracion, String nombre, String provincia, String correoAtencion, LocalDate fechaAlta, double precioEntrada) throws valoracionException, precioEntradaException, correoException {
        super(valoracion, nombre, provincia, correoAtencion, fechaAlta, precioEntrada);
        this.servicios = new ArrayList<>();

        Comprobacion.precioEntradaZooOK(this.precioEntrada);
        Comprobacion.valoracionOK(this.valoracion);
    }

    public Zoologico(int valoracion, String nombre, String provincia, String correoAtencion, LocalDate fechaAlta, double precioEntrada, List<String> servicios) throws valoracionException, precioEntradaException, correoException {
        super(valoracion, nombre, provincia, correoAtencion, fechaAlta, precioEntrada);
        this.servicios = new ArrayList<>(servicios);

        Comprobacion.precioEntradaZooOK(this.precioEntrada);
        Comprobacion.valoracionOK(this.valoracion);
    }

    public boolean addServicio (String servicio){
        return servicios.add(servicio);
    }

    public Zoologico() {
        super();

        Faker faker = new Faker();
        this.servicios = new ArrayList<>();
        servicios.add("Monos");
        servicios.add("Aves");
        this.precioEntrada= faker.number().numberBetween(10,20);
    }


    @Override
    public double precioEntradaReal(int edad, boolean isFestivo) {
        if (edad>0){
            if (edad <7){
                return 0;
            } else if (isFestivo){
                return precioEntrada = precioEntrada +precioEntrada*0.3;
            } else {
                return precioEntrada;
            }
        }
        return -1;
    }


    public String toString() {
        return String.format("ID: %d\n Valoracion: %d\n Nombre: %s\n Provincia: %s\n Correo Atencion: %s\n Fecha Alta: %s\n Precio Entrada: %.2f\nServicios: %s", this.getId(), this.getValoracion(), this.getNombre(), this.getProvincia(), this.getCorreoAtencion(), this.getFechaAlta(), this.getPrecioEntrada(), servicios.toString());
    }

    public String toStringFile (){
        return String.format("%d;%s;%s;%s;%s;%s;%s", this.getValoracion(), this.getNombre(), this.getProvincia(), this.getCorreoAtencion(), this.getFechaAlta().toString(), this.getPrecioEntrada(), this.servicios.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",")));
    }

}
