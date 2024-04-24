package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.common.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter@Setter
public class Fruta implements Comparable<Fruta>, Serializable {
    private String nombre,procedencia;
    private int numeroKilos;
    private double precioCostePorKilo,precioVentaPorKilo;
    private LocalDate fechaCaducidad;
public static int autonumerico = 1;



    public Fruta(String nombre, String procedencia, int numeroKilos, double precioCostePorKilo, double precioVentaPorKilo,LocalDate fechaCaducidad) throws precioVentaExcepcion, FechaInvalidaException {
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.numeroKilos = numeroKilos;
        this.precioCostePorKilo = precioCostePorKilo;
        this.precioVentaPorKilo = precioVentaPorKilo;
        this.fechaCaducidad = fechaCaducidad;
        EnumComprobacionDirecta.precioVentaOK(precioVentaPorKilo, precioCostePorKilo);
        EnumComprobacionDirecta.fechaOK(fechaCaducidad);
    }

    public Fruta (double precioCostePorKilo, double precioVentaPorKilo) throws precioVentaExcepcion {

        Frutas[] frutas= Frutas.values();
        Provincias[] provincias = Provincias.values();
        this.nombre = String.valueOf(frutas[(int) (Math.random() * frutas.length-1) +1]) + autonumerico;
        this.procedencia = provincias[(int) (Math.random() * provincias.length-1) + 1].toString();
        this.numeroKilos = (int) (Math.random() * 10000) + 1;
        this.fechaCaducidad = generarFechaAleatoria();
        this.precioCostePorKilo= precioCostePorKilo;
        this.precioVentaPorKilo=precioVentaPorKilo;
        autonumerico++;
    }

    public LocalDate generarFechaAleatoria() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Calcular el número de días entre la fecha actual y el año 2026
        long diasHasta2026 = ChronoUnit.DAYS.between(fechaActual, LocalDate.of(2032, 12, 12));
        // Generar un número aleatorio de días entre 0 y diasHasta2026
        long diasAleatorios = (long) (Math.random() * (diasHasta2026 + 1));
        // Calcular la fecha aleatoria sumando los días aleatorios a la fecha actual
        LocalDate fechaAleatoria = fechaActual.plusDays(diasAleatorios);
        return fechaAleatoria;
    }
    public String toString() {
        return String.format("Nombre de la fruta: %s\nProcedencia: %s\nNumero de kilos: %d\nPrecio Coste por kilo: %.2f\nPrecio de venta por kilo: %.2f\nFecha de caducidad %s\n",
                nombre, procedencia, numeroKilos, precioCostePorKilo, precioVentaPorKilo,fechaCaducidad);
    }

    public String toStringFile(){
    return nombre+";"+procedencia+";"+numeroKilos+";"+precioCostePorKilo+";"+precioVentaPorKilo+";"+fechaCaducidad;
    }

    @Override
    public int compareTo(Fruta o) {
        return Double.compare(this.precioVentaPorKilo,o.precioVentaPorKilo);
    }
}
