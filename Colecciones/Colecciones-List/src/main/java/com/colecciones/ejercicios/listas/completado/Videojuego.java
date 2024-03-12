package com.colecciones.ejercicios.listas.completado;

import java.util.Objects;

public class Videojuego implements Entregable {
    private String titulo,genero,companyia;
    private int hrsEstimadas;
    private boolean isEntregado;

    public Videojuego() {
    }

    public Videojuego(String titulo, String genero, String companyia, int hrsEstimadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.companyia = companyia;
        this.hrsEstimadas = hrsEstimadas;
        this.isEntregado=false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompanyia() {
        return companyia;
    }

    public void setCompanyia(String companyia) {
        this.companyia = companyia;
    }

    public int getHrsEstimadas() {
        return hrsEstimadas;
    }

    public void setHrsEstimadas(int hrsEstimadas) {
        this.hrsEstimadas = hrsEstimadas;
    }

    public boolean isEntregado() {
        return isEntregado;
    }

    public void setEntregado(boolean entregado) {
        isEntregado = entregado;
    }

    @Override
    public void entregar() {
        isEntregado = true;
    }

    @Override
    public void devolver() {
        isEntregado=false;
    }

    @Override
    public boolean comprobarSiElArticuloEsEntregado() {
        return isEntregado;
    }


    public boolean equals(Videojuego videojuego) {
        return this.titulo.trim().equalsIgnoreCase(videojuego.getTitulo()) && this.companyia.trim().equalsIgnoreCase(videojuego.getCompanyia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, genero, companyia, hrsEstimadas, isEntregado);
    }

    @Override
    public int compareTo(Object o) {
        int index=IGUAL;
        if (o instanceof Videojuego){
            if (this.hrsEstimadas>((Videojuego) o).getHrsEstimadas()){
                index = MAYOR;
            } else if (this.hrsEstimadas==((Videojuego) o).getHrsEstimadas()){
                index=IGUAL;
            } else {
                index=MENOR;
            }
        }
        return index;
    }


}
