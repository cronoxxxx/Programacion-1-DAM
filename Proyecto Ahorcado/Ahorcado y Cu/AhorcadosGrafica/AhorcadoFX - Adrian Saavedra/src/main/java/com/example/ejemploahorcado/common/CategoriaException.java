/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemploahorcado.common;

import java.util.Arrays;

/**
 *
 * @author examen
 */
public class CategoriaException extends Exception {
    public CategoriaException() {
        super("La categoria debe de ser alguna de las siguientes "+Arrays.toString(Categoria.values()));
    }

    public CategoriaException(String categoria) {
        super("La categoria "+categoria+ " debe de ser alguna de las siguientes "+Arrays.toString(Categoria.values()));
    }
}
