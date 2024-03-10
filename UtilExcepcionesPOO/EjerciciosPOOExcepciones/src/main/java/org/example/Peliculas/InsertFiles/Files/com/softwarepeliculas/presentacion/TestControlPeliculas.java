package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.presentacion;


import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Actor;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Pelicula;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.servicio.ControlPeliculasImpl;
import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.servicio.IControlPeliculas;

import java.util.Scanner;

public class TestControlPeliculas {

    public static void main(String[] args) {
        IControlPeliculas controlPeliculas = new ControlPeliculasImpl();
        Scanner entrada = new Scanner(System.in);
        Actor actor;
        String nombrePeli, nombreActor,respuesta;
        int opcion,anyo,edad;
        boolean isEstreno = false, isFamosa=false, esFamoso = false;
        Pelicula p;
        System.out.println("SOFTWARE - CONTROL DE PELICULAS");
        System.out.println("----------------------------------");
        do {
            System.out.println("Bienvenido, ingrese una opcion: ");
            System.out.println("1. Iniciar control de peliculas");
            System.out.println("2. Agregar peliculas");
            System.out.println("3. Lista peliculas");
            System.out.println("4.Buscar peliculas");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    controlPeliculas.iniciarControlDePeliculas();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombrePeli=entrada.nextLine();
                    System.out.println("Ingrese el año de estreno");
                    anyo=entrada.nextInt();
                    do {
                        System.out.println("¿Esta en estreno? (si/no)");
                        respuesta=entrada.nextLine();
                        if (respuesta.trim().equalsIgnoreCase("si")){
                            isEstreno=true;
                        } else if (respuesta.trim().equalsIgnoreCase("no")){
                            isEstreno=false;
                        } else {
                            System.err.println("Respuesta no valida, siga intentandolo");
                        }
                    }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));
                    do {
                        System.out.println("¿Es famosa? (si/no)");
                        respuesta=entrada.nextLine();
                        if (respuesta.trim().equalsIgnoreCase("si")){
                            isFamosa=true;
                        } else if (respuesta.trim().equalsIgnoreCase("no")){
                            isFamosa=false;
                        } else {
                            System.err.println("Respuesta no valida, siga intentandolo");
                        }
                    }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));

                    System.out.println("Ingrese el nombre del protagonista principal: ");
                    nombreActor=entrada.nextLine();
                    System.out.println("Ingrese su edad: ");
                    edad= entrada.nextInt();
                    do {
                        System.out.println("¿Es famoso/a? (si/no)");
                        respuesta=entrada.nextLine();
                        if (respuesta.trim().equalsIgnoreCase("si")){
                            esFamoso=true;
                        } else if (respuesta.trim().equalsIgnoreCase("no")){
                            esFamoso=false;
                        } else {
                            System.err.println("Respuesta no valida, siga intentandolo");
                        }
                    }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));

                    actor= new Actor(edad,nombreActor,esFamoso);
                    p = new Pelicula(nombrePeli,anyo,isEstreno,isFamosa,actor);
                    controlPeliculas.agregarPelicula(p);
                    break;
                case 3:
                    System.out.println(" ");
                    controlPeliculas.listarPeliculas();

                    break;
                case 4:
                    entrada.nextLine();
                    System.out.println(" ");
                    System.out.println("Ingrese la pelicula a buscar");
                    nombrePeli=entrada.nextLine();
                    p = new Pelicula(nombrePeli);
                    controlPeliculas.buscarPelicula(p);
                    break;
                case 5:
                    System.out.println("GRACIAS POR PARTICIPAR, TEN UN BUEN DIA :D");
                    break;
                default:
                    System.err.println("Opcion no disponible, vuelvalo a intentar");

            }
        } while (opcion != 5);
    }

}
