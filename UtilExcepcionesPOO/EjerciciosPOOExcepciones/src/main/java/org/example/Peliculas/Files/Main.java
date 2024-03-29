package org.example.Peliculas.Files;

import java.util.Scanner;

/*Crear un software para un control de peliculas, para esto debes aplicar
* todos los temas de POO, archivos y excepciones, debe almacenar la informacion
* de las peliculas en un archivo de texto, en una carpeta definida
*
* . Iniciar control de peliculas
* . Agregar peliculas
* . Listar pelicula
* . Buscar pelicula
* . Salir
*
*
*
* */
public class Main {
    public static void main(String[] args) {
    menu();

    }

    public static void menu(){
        Scanner entrada= new Scanner(System.in);
        Programa programa = new Programa();
        Pelicula p;
        int opcion;
        do {
            System.out.println("Bienvenido: ");
            System.out.println("1. Listar peliculas");
            System.out.println("2. Añadir pelicula");
            System.out.println("3. Buscar pelicula");
            System.out.println("4. Salir");
            System.out.println("Ingrese la opcion: ");
            opcion= entrada.nextInt();
            String nombre;

            int anyo = 0;
            boolean isEstreno=false;
            boolean isFamosa=false;
            Actor actorPrincipal=new Actor();


            switch (opcion){
                case 1:
                    programa.listarPeliculas();
                    break;
                case 2:
                    entrada.nextLine();
                    System.out.println("Ingresa el nombre de la pelicula");
                    nombre=entrada.nextLine();
                        System.out.println("Ingresa el año de estreno");
                        anyo= entrada.nextInt();
                    entrada.nextLine();
                    String respuesta;

                    do {
                        System.out.println("¿Esta en estreno?");
                        respuesta= entrada.nextLine();
                        if (respuesta.equalsIgnoreCase("no")){
                            isEstreno=false;
                        } else if (respuesta.equalsIgnoreCase("si")){
                            isEstreno=true;
                        } else {
                            System.out.println("Asigne un valor estre si y no");
                        }
                    }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));

                    do {
                        System.out.println("¿Es famosa?");
                        respuesta= entrada.nextLine();
                        if (respuesta.equalsIgnoreCase("no")){
                            isFamosa=false;
                        } else if (respuesta.equalsIgnoreCase("si")){
                            isFamosa=true;
                        } else {
                            System.out.println("Asigne un valor estre si y no");
                        }
                    }while (!(respuesta.trim().equalsIgnoreCase("si") || respuesta.trim().equalsIgnoreCase("no")));
                    p=new Pelicula(nombre, anyo,isEstreno,isFamosa,actorPrincipal);
                    programa.addPelicula(p);
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println("Ingresa el nombre de la pelicula");
                    nombre=entrada.nextLine();
                    programa.buscarPelicula(nombre);
                    break;
                case 4:
                    System.out.println("VUELVA PRONTO");


                    break;
                default:
                    System.err.println("Opcion no valida");
            }
        }while (opcion!=4);

    }
}