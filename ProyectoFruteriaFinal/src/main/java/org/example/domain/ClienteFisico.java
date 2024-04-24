package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteFisico extends Cliente {

    private int ordenFila;
    private static int asignacion = 1;
    public ClienteFisico(String nombre, String apellidos, int ordenFila, boolean hasDescuento) {
        super(nombre, apellidos,hasDescuento);
        this.ordenFila = ordenFila;
    }

    public ClienteFisico(String nombre, String apellidos, boolean hasDescuento) {
        super(nombre, apellidos,hasDescuento);
        this.ordenFila = asignacion;
        asignacion++;
    }

    public ClienteFisico() {
        this.ordenFila = asignacion;
        asignacion++;
    }

    //hacer constructores con valores randoms y copiar esto a un archivo binario o ver lo de los properties y el json (preguntar a gema)


    @Override
    public String toString() {
        return String.format("Nombre: %s\nApellido %s\nTicket descuento: %b\nOrden de fila: %d\n",nombre,apellidos,hasDescuento,ordenFila);
    }
}
