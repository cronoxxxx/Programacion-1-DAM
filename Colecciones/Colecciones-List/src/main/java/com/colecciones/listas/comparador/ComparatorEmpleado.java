package com.colecciones.listas.comparador;

import java.util.Comparator;

public class ComparatorEmpleado implements Comparator<Empleado> {
    @Override
    public int compare(Empleado primero, Empleado segundo) {
        //return primero.getNombre().compareTo(segundo.getNombre());
        if (primero.getEdad()>segundo.getEdad()){
            return  1;
        } else if(primero.getEdad()<segundo.getEdad()){
            return -1;
        }
        return 0;
    }
}
