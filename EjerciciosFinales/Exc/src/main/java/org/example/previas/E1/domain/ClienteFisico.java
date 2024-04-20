package org.example.previas.E1.domain;

import java.io.Serializable;

public class ClienteFisico extends Cliente {

    private int ordenFila;
    private static int asignacion = 1;
    public ClienteFisico(String nombre, int ordenFila) {
        super(nombre);
        this.ordenFila = ordenFila;
    }

    public ClienteFisico(String nombre) {
        super(nombre);
        this.ordenFila = asignacion;
        asignacion++;
    }

    public ClienteFisico() {
        this.ordenFila = asignacion;
        asignacion++;
    }

    //hacer constructores con valores randoms y copiar esto a un archivo binario o ver lo de los properties y el json (preguntar a gema)
    public int getOrdenFila() {
        return ordenFila;
    }

    public void setOrdenFila(int ordenFila) {
        this.ordenFila = ordenFila;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nOrden de fila: %d\n",nombre,ordenFila);
    }
}
