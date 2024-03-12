package com.colecciones.ejercicios.listas.completado;

public interface Entregable {
    int MAYOR=1, MENOR=-1, IGUAL=0;
    void entregar();
    void devolver();
    boolean comprobarSiElArticuloEsEntregado();
    int compareTo(Object o);



}
