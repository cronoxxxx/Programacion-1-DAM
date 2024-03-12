package com.colecciones.ejercicios.listas.completado;

import java.util.Objects;

public class Serie implements Entregable{
    private String nombre, creador, genero;
    private int numTemporadas;
    private boolean isEntregado;

    public Serie(String nombre, String creador, String genero, int numTemporadas) {
        this.nombre = nombre;
        this.creador = creador;
        this.genero = genero;
        this.numTemporadas = numTemporadas;
        this.isEntregado=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcreador() {
        return creador;
    }

    public void setcreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    @Override
    public void entregar() {
        isEntregado=true;
    }

    @Override
    public void devolver() {
        isEntregado=false;
    }

    @Override
    public boolean comprobarSiElArticuloEsEntregado() {
        return isEntregado;
    }


    public boolean equals(Serie serie) {
       return this.nombre.trim().equalsIgnoreCase(serie.getNombre()) && this.creador.trim().equalsIgnoreCase(serie.getcreador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, creador, genero, numTemporadas, isEntregado);
    }

    @Override
    public int compareTo(Object o) {
        int INDEX = IGUAL;
        if(o instanceof Serie){
            if (this.numTemporadas>((Serie) o).getNumTemporadas()){
                INDEX = MAYOR;
            } else if (this.numTemporadas==((Serie) o).getNumTemporadas()){
                INDEX = IGUAL;
            } else {
                INDEX = MENOR;
            }
        }
        return INDEX;
    }
        
}
