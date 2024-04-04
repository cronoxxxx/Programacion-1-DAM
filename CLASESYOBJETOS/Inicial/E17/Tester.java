package EJERCICIOS.CLASESYOBJETOS.Inicial.E17;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ColeccionLibros c = new ColeccionLibros();
        int opcion;
        do {
            System.out.println("Bienvenido a la gestion de libros");
            System.out.println("1. Añadir libros");
            System.out.println("2. Eliminar libros por titulo y autor");
            System.out.println("3. Mostrar libros con mayor y menor calificacion");
            System.out.println("4. Mostrar la información de un libro por titulo");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> {
                    c.añadirLibro();
                }
                case 2 -> {
                    c.eliminarLibrosTituloAutor();
                }
                case 3 -> {
                    c.mostrarLibroMayorMenorCalificacion();
                }
                case 4 -> {
                    c.infoLibroTitulo();
                }
                case 5 -> {
                    c.mostrarLibros();
                }
                case 6 -> {
                    System.out.println("VUELVA PRONTO ! ! !");
                }

            }
        } while (opcion!=6);

    }
}
