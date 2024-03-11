package com.colecciones.ejercicios.listas;

import java.util.Objects;
import java.util.StringJoiner;

public final class Serie implements Entregable {
    private int numTemporadas;
    private boolean isEntregado;
    private String genero, creador, titulo;

    public Serie(int numTemporadas, String genero, String creador, String titulo) {
        this.numTemporadas = numTemporadas;
        this.isEntregado = false;
        this.genero = genero;
        this.creador = creador;
        this.titulo = titulo;
    }

    public Serie(int numTemporadas, boolean isEntregado, String genero, String creador) {
        this.numTemporadas = numTemporadas;
        this.isEntregado = isEntregado;
        this.genero = genero;
        this.creador = creador;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public boolean isEntregado() {
        return isEntregado;
    }

    public void setEntregado(boolean entregado) {
        isEntregado = entregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void entregar() {
        isEntregado = true;
    }

    @Override
    public void devolver() {
        isEntregado = false;
    }

    @Override
    public boolean comrprobarSiElArticuloEsEntregado() {
        return isEntregado;
    }


    @Override
    public String toString() {
        return String.format("Titulo: %s\nNumero de temporadas: %d\nGenero: %s\nCreador: %s\n ¿Esta entregado?:  %b\n", titulo, numTemporadas, genero, creador, isEntregado);
    }


    public boolean equals(Serie serie) {
        return this.titulo.equalsIgnoreCase(serie.getTitulo()) && this.creador.equalsIgnoreCase(serie.getCreador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTemporadas, isEntregado, genero, creador, titulo);
    }

    @Override
    public int compareTo(Object o) {
        int estado = MENOR;
        //Casteo para usar get
        if (o instanceof Serie) {
            Serie serie = (Serie) o;
            if (this.numTemporadas > serie.getNumTemporadas()) {
                estado = MAYOR;
            } else if (this.numTemporadas == serie.getNumTemporadas()) {
                estado = IGUAL;
            } else {
                estado = MENOR;
            }
        }
        return estado;

    }
}
