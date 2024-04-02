package ui;


import common.Categoria;
import common.CategoriaException;
import common.Comprobacion;
import dao.IDException;
import dao.Palabras;
import domain.Juego;
import domain.Palabra;
import net.datafaker.Faker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        for (int i = 0; i < 2000; i++) {
            System.out.print("clap"+ " ");
        }


        try {
            PruebaTotal.iniciarMenuJuego();
        } catch (CategoriaException e) {
            throw new RuntimeException(e);
        }
    }
}


