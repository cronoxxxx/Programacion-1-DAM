package com.colecciones.ejercicios.listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        List<Serie> listaSeries = new ArrayList<>();
        List<Videojuego> listaVideojuegos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Serie serie = generarSerieAleatoria();
            listaSeries.add(serie);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            Videojuego v = generarVideojuegoAleatorio();
            listaVideojuegos.add(v);
        }
        for (int i = 0; i < listaSeries.size(); i++) {
            listaSeries.get(i).entregar();
        }
        for (int i = 0; i < listaVideojuegos.size(); i++) {
            listaVideojuegos.get(i).entregar();
        }

        int entregados = 0;
        for (int i = 0; i < listaSeries.size(); i++) {
            if (listaSeries.get(i).comrprobarSiElArticuloEsEntregado()) {
                entregados++;
                listaSeries.get(i).devolver(); //comprobamos cuantos estan entregados y los devolvemos
            }
        }
        System.out.println("Cantidad de entregados: " + entregados);
//HALLAMOS EL MAYOR ELEMENTO DE LAS LISTAS DE VIDEJUEGOS Y SERIES
        Serie serieMayor = listaSeries.get(0);
        Videojuego videojuegoMayor = listaVideojuegos.get(0);
        for (int i = 0; i < listaSeries.size(); i++) {
            if (listaSeries.get(i).compareTo(serieMayor) == Serie.MAYOR) {
                serieMayor = listaSeries.get(i);
            }
        }
        for (int i = 0; i < listaVideojuegos.size(); i++) {
            if (listaVideojuegos.get(i).compareTo(videojuegoMayor) == Serie.MAYOR) {
                videojuegoMayor = listaVideojuegos.get(i);
            }
        }
        //HALLAMOS EL VALOR MINIMO DE AMBOS
        Serie serieMenor = listaSeries.get(0);
        Videojuego videojuegoMenor = listaVideojuegos.get(0);

        for (int i = 0; i < listaSeries.size(); i++) {
            if (listaSeries.get(i).compareTo(serieMenor) == Serie.MENOR) {
                serieMenor = listaSeries.get(i);
            }
        }

        for (int i = 0; i < listaVideojuegos.size(); i++) {
            if (listaVideojuegos.get(i).compareTo(videojuegoMenor) == Serie.MENOR) {
                videojuegoMenor = listaVideojuegos.get(i);
            }
        }
        System.out.println("Articulo mayor: ");
        System.out.println("-----------------");
        System.out.println(serieMayor);
        System.out.println("Articulo menor");
        System.out.println(serieMenor);

        System.out.println("\nVideojuegos con mayor hora estimada");
        System.out.println(videojuegoMayor);
        System.out.println("Videojuego con menor hora estimada");
        System.out.println(videojuegoMenor);

    }

    private static Serie generarSerieAleatoria() {
        Random random = new Random();

        int temporadas = random.nextInt(10) + 1; // Entre 1 y 10 temporadas
        String genero = obtenerGeneroAleatorio();
        String creador = obtenerCreadorAleatorio();
        String nombre = obtenerNombreAleatorio();

        return new Serie(temporadas, genero, creador, nombre);
    }

    private static Videojuego generarVideojuegoAleatorio() {
        Random random = new Random();
        int hrsEstimadas = random.nextInt(20) + 1;
        String titulo = obtenerJuegoAleatorio();
        String genero = obtenerGeneroAleatorio();
        String companyia = obtenerCompanyRandom();
        return new Videojuego(titulo, genero, companyia, hrsEstimadas);
    }

    private static String obtenerJuegoAleatorio() {
        String[] videojuegos = {"GOAT Simulator", "Flappy Bird", "GTA V", "Geometry Dash", "Minecraft"};
        Random random = new Random();
        return videojuegos[random.nextInt(videojuegos.length)];
    }

    private static String obtenerCompanyRandom() {
        String[] companies = {"CAPCOM", "Mojang", "Rockstar", "Robtop", "GAMELOFT"};
        Random random = new Random();
        return companies[random.nextInt(companies.length)];
    }


    private static String obtenerGeneroAleatorio() {
        String[] generos = {"Drama", "Comedia", "Acción", "Suspense", "Ciencia Ficción", "Fantasía"};
        Random random = new Random();
        return generos[random.nextInt(generos.length)];
    }

    private static String obtenerCreadorAleatorio() {
        String[] creadores = {"Netflix", "HBO", "Amazon Prime", "Disney+", "BBC"};
        Random random = new Random();
        return creadores[random.nextInt(creadores.length)];
    }

    private static String obtenerNombreAleatorio() {
        String[] nombres = {"Stranger Things", "Breaking Bad", "The Mandalorian", "Fleabag", "The Crown"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }
}
