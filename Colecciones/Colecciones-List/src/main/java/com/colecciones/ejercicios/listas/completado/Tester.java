package com.colecciones.ejercicios.listas.completado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        menu();

    }

    private static void menu(){
        Scanner entrada= new Scanner(System.in);
        List<Videojuego> videojuegoList = new ArrayList<>();
        List<Serie> serieList= new ArrayList<>();

        int opcion =0;
        String titulo,genero,companyia,creador;
        int hrsEstimadas,numTemporadas;
        boolean isEntregado;
        do {
            System.out.println("1. Agregar videojuego");
            System.out.println("2. Agregar serie");
            System.out.println("3. Listar videojuegos y series");
            opcion= entrada.nextInt();
            switch (opcion){
                case 1:
                    entrada.nextLine();
                    System.out.println("Ingresa el titulo");
                    titulo=entrada.nextLine();
                    System.out.println("Genero: ");
                    genero = entrada.nextLine();
                    System.out.println("Compañia");
                    companyia=entrada.nextLine();
                    System.out.println("Horas estimadas ");
                    hrsEstimadas= entrada.nextInt();
                    videojuegoList.add(new Videojuego(titulo,genero,companyia,hrsEstimadas));
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Ingresa el titulo");
                    titulo=entrada.nextLine();
                    System.out.println("Genero: ");
                    genero = entrada.nextLine();
                    System.out.println("Creador");
                    creador=entrada.nextLine();
                    System.out.println("Cuantas series tiene ");
                    numTemporadas= entrada.nextInt();
                    serieList.add(new Serie(titulo,genero,creador,numTemporadas));
                    break;
                case 3:
                        try {

                            for (int i = 0; i < serieList.size(); i++) {
                                System.out.println(serieList.get(i));
                            }
                            Serie mayor = serieList.get(0);
                            for (int i = 0; i < serieList.size() ; i++) {
                                if (serieList.get(i).compareTo(mayor)==1){
                                    mayor=serieList.get(i);

                                }
                            }
                            System.out.println("SERIE CON MENOS TEMPORADAS: "+mayor);

                            Serie menor = serieList.get(0);
                            for (int i = 0; i < serieList.size() ; i++) {
                                if (serieList.get(i).compareTo(menor)==-1){
                                    menor=serieList.get(i);

                                }
                            }
                            System.out.println("SERIE CON MAS TEMPORADAS: "+menor);

                            for (int i = 0; i < videojuegoList.size(); i++) {
                                System.out.println(videojuegoList.get(i));
                            }



                            Videojuego mayor1 = videojuegoList.get(0);
                            for (int i = 0; i < videojuegoList.size() ; i++) {
                                if (videojuegoList.get(i).compareTo(mayor1)==1){
                                    mayor1=videojuegoList.get(i);

                                }
                            }
                            System.out.println("VIDEOJUEGO CON MAS HORAS: "+mayor1);

                            Videojuego menor1 = videojuegoList.get(0);
                            for (int i = 0; i < videojuegoList.size() ; i++) {
                                if (videojuegoList.get(i).compareTo(menor1)==-1){
                                    menor1=videojuegoList.get(i);

                                }
                            }
                            System.out.println("VIDEOJUEGO CON MENOS HORAS: "+menor1);

                        } catch (IndexOutOfBoundsException i){
                            System.out.println("No se puede iterar ya que no hay valores");

                        }
                    break;
            }
        }while (opcion!=6);

    }
}
