package com.colecciones.ejercicios.listas;

public interface Entregable {

    int MAYOR = 1;
    int MENOR = -1;
    int IGUAL = 0;
    void entregar ();
    void devolver();
    boolean comrprobarSiElArticuloEsEntregado();
    int compareTo(Object o);



}
