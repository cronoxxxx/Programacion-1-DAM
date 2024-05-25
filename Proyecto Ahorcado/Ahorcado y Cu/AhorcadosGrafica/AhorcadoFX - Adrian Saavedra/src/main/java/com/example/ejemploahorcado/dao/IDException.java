package com.example.ejemploahorcado.dao;

import com.example.ejemploahorcado.common.Categoria;

import java.util.Arrays;

public class IDException extends Exception{
    public IDException(int id) {
        super("La excepcion en la posicion "+id+" ya esta asignado a un elemento");
    }

    public IDException() {
        super("El id no debe estar repetido "+ Arrays.toString(Categoria.values()));
    }
}
