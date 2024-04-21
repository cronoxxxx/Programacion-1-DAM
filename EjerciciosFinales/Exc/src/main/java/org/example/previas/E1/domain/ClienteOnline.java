package org.example.previas.E1.domain;

import net.datafaker.Faker;
import org.example.previas.E1.common.EnumComprobacionDirecta;
import org.example.previas.E1.common.FechaInvalidaException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ClienteOnline extends Cliente {
    private LocalDate fechaEntregaPedido;
    private String direccionEntregaPedido;
    public ClienteOnline(String nombre, String apellidos, LocalDate fechaEntregaPedido, String direccionEntregaPedido, boolean hasDescuento) throws FechaInvalidaException {
        super(nombre, apellidos,hasDescuento);
        this.fechaEntregaPedido = fechaEntregaPedido;
        this.direccionEntregaPedido = direccionEntregaPedido;
        EnumComprobacionDirecta.fechaOK(fechaEntregaPedido);
    }

    public ClienteOnline() {
        Faker f = new Faker();
        this.fechaEntregaPedido = generarFechaAleatoria();
        this.direccionEntregaPedido = f.address().fullAddress();

    }

    public LocalDate getFechaEntregaPedido() {
        return fechaEntregaPedido;
    }

    public void setFechaEntregaPedido(LocalDate fechaEntregaPedido) {
        this.fechaEntregaPedido = fechaEntregaPedido;
    }

    public String getDireccionEntregaPedido() {
        return direccionEntregaPedido;
    }

    public void setDireccionEntregaPedido(String direccionEntregaPedido) {
        this.direccionEntregaPedido = direccionEntregaPedido;
    }

    public LocalDate generarFechaAleatoria() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Calcular el número de días entre la fecha actual y el año 2026
        long diasHasta2026 = ChronoUnit.DAYS.between(fechaActual, LocalDate.of(2026, 1, 1));
        // Generar un número aleatorio de días entre 0 y diasHasta2026
        long diasAleatorios = (long) (Math.random() * (diasHasta2026 + 1));
        // Calcular la fecha aleatoria sumando los días aleatorios a la fecha actual
        LocalDate fechaAleatoria = fechaActual.plusDays(diasAleatorios);
        return fechaAleatoria;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nApellido %s\nDireccion del pedido: %s\nTicket descuento: %b\nFecha de la entrega: %s\n",nombre,apellidos,direccionEntregaPedido,hasDescuento,fechaEntregaPedido);
    }
}
