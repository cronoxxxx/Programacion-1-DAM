package com.colecciones.ejercicios.listas;

public class Videojuego implements Entregable {
    private String titulo,genero,companyia;
    private int hrsEstimadas;
    private boolean isEntregado;
    @Override
    public void entregar() {
        isEntregado=true;
    }

    public Videojuego(String titulo, String genero, String companyia, int hrsEstimadas, boolean isEntregado) {
        this.titulo = titulo;
        this.genero = genero;
        this.companyia = companyia;
        this.hrsEstimadas = hrsEstimadas;
        this.isEntregado = isEntregado;
    }
    public Videojuego(String titulo, String genero, String companyia, int hrsEstimadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.companyia = companyia;
        this.hrsEstimadas = hrsEstimadas;
        this.isEntregado = false;
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

    @Override
    public void devolver() {
    isEntregado=false;
    }

    public boolean equals(Videojuego v){
        return this.companyia.equalsIgnoreCase(v.getCompanyia()) && this.titulo.equalsIgnoreCase(v.getTitulo());
    }

    @Override
    public boolean comrprobarSiElArticuloEsEntregado() {
        return  isEntregado;
    }

    @Override
    public int compareTo(Object o) {
        int estado = MENOR;
        if (o instanceof  Videojuego){
            Videojuego v = (Videojuego) o;
            if (this.hrsEstimadas> v.getHrsEstimadas()){
                estado=MAYOR;
            } else  if (this.hrsEstimadas==v.getHrsEstimadas()){
                estado=IGUAL;
            } else {
                estado=MENOR;
            }

        }
        return estado;
    }
    @Override
    public String toString() {
        return String.format("Titulo: %s\nCompañia: %s\nGenero: %s\nHoras estimadas: %d\n ¿Esta entregado?:  %b\n", titulo, companyia, genero, hrsEstimadas, isEntregado);
    }
}
