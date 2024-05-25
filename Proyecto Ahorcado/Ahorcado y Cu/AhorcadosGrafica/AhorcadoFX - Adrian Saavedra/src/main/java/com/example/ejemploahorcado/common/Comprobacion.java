package com.example.ejemploahorcado.common;

public class Comprobacion {

    public static void categoriaOk(String categoria) throws CategoriaException {
        boolean esta = false;
        Categoria []aux = Categoria.values();
        for (int i = 0; i < aux.length && !esta; i++) {
            if (aux[i].toString().equalsIgnoreCase(categoria)){
                    esta=true;
            }
        }
        if (!esta){
            throw  new CategoriaException(categoria);
        }

    }
}



