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
        try {
            PruebaTotal.iniciarMenuJuego();
        } catch (CategoriaException e) {
            throw new RuntimeException(e);
        }
    }
}


