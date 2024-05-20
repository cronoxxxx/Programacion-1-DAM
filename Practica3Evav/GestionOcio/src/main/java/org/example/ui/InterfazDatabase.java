package org.example.ui;

import org.example.common.correoException;
import org.example.common.precioEntradaException;
import org.example.common.valoracionException;
import org.example.dao.DaoFicheros;
import org.example.dao.Database;
import org.example.domain.CentrosOcio;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoologico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.example.common.Constantes;
import org.example.service.GestionDatabase;

import static org.example.common.Constantes.*;

public class InterfazDatabase {


    public static void menuPrincipal() {
        GestionDatabase gestionDatabase = new GestionDatabase();
        int op = 0;
        do {
            System.out.println(MENU_PRINCIPAL);
            System.out.println(OPCIONES);
            System.out.println(INTRODUZCA_LA_OPCION);
            op = menu();
            switch (op) {
                case 1 -> mostrarInformacion(gestionDatabase);
                case 2 -> agregarCentro(gestionDatabase);
                case 3 -> mostrarCentrosPorProvincia(gestionDatabase);
                case 4 -> agregarServicio(gestionDatabase);
                case 5 -> mostrarParquesOrdenados(gestionDatabase);
                case 6 -> eliminarCentrosPorAnyo(gestionDatabase);
                case 7 -> mostrarCentrosPorProvinciaConNumeroDeCentros(gestionDatabase);
                case 8 -> {
                    gestionDatabase.escribirBinario();
                    gestionDatabase.escribirZoologicos();
                    System.out.println("Se han guardado los datos");
                }
                default -> {
                    System.out.println("Opcion incorrecta");
                }
            }

        } while (op != 8);
    }

    private static void mostrarCentrosPorProvinciaConNumeroDeCentros(GestionDatabase gestionDatabase) {
        if (gestionDatabase.obtenerCentrosPorProvinciaConNumeroDeCentros().isEmpty() || gestionDatabase.obtenerCentrosPorProvinciaConNumeroDeCentros() == null) {
            System.out.println("No hay centros");
        } else {
            gestionDatabase.obtenerCentrosPorProvinciaConNumeroDeCentros().forEach((key, value) -> System.out.println(key + ": " + value));
        }

    }

    private static void eliminarCentrosPorAnyo(GestionDatabase gestionDatabase) {
        System.out.println("Introduzca el anyo");
        int anyo = menu();
        if (gestionDatabase.eliminarCentrosPorAnyo(anyo)) {
            System.out.println("Se han eliminado los centros");
        } else {
            System.out.println("No se han podido eliminar los centros");
        }
    }

    private static void mostrarParquesOrdenados(GestionDatabase gestionDatabase) {
        System.out.println("Ingrese la edad");
        int edad = menu();
        System.out.println("¿Es festivo?");
        System.out.println("1. Si");
        System.out.println("2. No");
        boolean festivo = menu() == 1;
        if (gestionDatabase.devolverParquesOrdenados(edad, festivo).isEmpty() || gestionDatabase.devolverParquesOrdenados(edad, festivo) == null) {
            System.out.println("No hay parques");
        } else {
            gestionDatabase.devolverParquesOrdenados(edad, festivo).forEach(System.out::println);
        }
    }

    private static void agregarServicio(GestionDatabase gestionDatabase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca el id");
        int id = menu();
        System.out.println("Introduzca el servicio");
        String servicio = entrada.nextLine();
        if (gestionDatabase.addServicioZoo(id, servicio)) {
            System.out.println("Se ha añadido el servicio");
        } else {
            System.out.println("No se ha podido añadir el servicio");
        }
    }


    public static void mostrarInformacion(GestionDatabase gestionDatabase) {
        System.out.println("Selecciones por que orden deseas ver la informacion");
        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        System.out.println("Introduzca la opcion");
        int op = 0;
        op = menu();
        switch (op) {
            case 1 -> gestionDatabase.mostrarInformacion(true).forEach(System.out::println);
            case 2 -> gestionDatabase.mostrarInformacion(false).forEach(System.out::println);
            default -> System.out.println("Opcion incorrecta");
        }
    }

    public static void agregarCentro(GestionDatabase gestionDatabase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el tipo de centro");
        System.out.println("1. Zoologico");
        System.out.println("2. Parque de atracciones");
        int op = menu();
        switch (op) {
            case 1 -> {
                System.out.println("Introduzca el nombre del zoologico");
                String zoo = entrada.nextLine();
                System.out.println("Introduzca la provincia");
                String prov = entrada.nextLine();
                System.out.println("Introduzca el correo de atencion");
                String correo = entrada.nextLine();
                System.out.println("Introduzca la fecha de alta");
                String fecha = entrada.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(fecha, formatter);
                System.out.println("Introduzca el precio de entrada");
                double precio = entrada.nextDouble();
                System.out.println("Ingrese la valoracion media");
                int valoracion = entrada.nextInt();

                System.out.println("¿Cuantos servicios tiene el zoo?");
                int numServicios = entrada.nextInt();
                entrada.nextLine();
                List<String> servicios = new ArrayList<>();
                for (int i = 0; i < numServicios; i++) {
                    System.out.println("Introduzca el servicio");
                    String servicio = entrada.nextLine();
                    servicios.add(servicio);
                }
                Zoologico z = null;
                try {
                    z = new Zoologico(valoracion, zoo, prov, correo, date, precio, servicios);
                    if (gestionDatabase.addCentro(z)) {
                        System.out.println("zoo añadido");
                    } else {
                        System.out.println("No se ha podido añadir el zoo");
                    }
                } catch (valoracionException | precioEntradaException | correoException e) {
                    throw new RuntimeException(e);
                }

            }
            case 2 -> {
                System.out.println("Introduzca el nombre del parque");
                String parque = entrada.nextLine();
                System.out.println("Introduzca la provincia");
                String prov = entrada.nextLine();
                System.out.println("Introduzca el correo de atencion");
                String correo = entrada.nextLine();
                System.out.println("Introduzca la fecha de alta");
                String fecha = entrada.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(fecha, formatter);
                System.out.println("Introduzca el precio de entrada");
                double precio = entrada.nextDouble();
                System.out.println("Ingrese la edad minima");
                int edad = entrada.nextInt();
                System.out.println("Ingrese la valoracion media");
                int valoracion = entrada.nextInt();
                ParqueAtracciones pq = null;
                try {
                    pq = new ParqueAtracciones(valoracion, parque, prov, correo, date, precio, edad);
                    if (gestionDatabase.addCentro(pq)) {
                        System.out.println("parque añadido");
                    } else {
                        System.out.println("No se ha podido añadir el parque");
                    }
                } catch (precioEntradaException | valoracionException | correoException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> System.out.println("Opcion incorrecta");
        }
    }

    public static void mostrarCentrosPorProvincia(GestionDatabase gestionDatabase) {
        System.out.println("Introduzca la provincia");
        Scanner entrada = new Scanner(System.in);
        String prov = entrada.nextLine();
        if (gestionDatabase.consultaCentrosPorProvincia(prov).isEmpty() || gestionDatabase.consultaCentrosPorProvincia(prov) == null) {
            System.out.println("No hay centros en esta provincia");
        } else {
            gestionDatabase.consultaCentrosPorProvincia(prov).forEach(System.out::println);
        }
    }


    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        try {
            op = entrada.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(FORMATO_INCORRECTO_EN_LA_LINEA);
        }
        return op;
    }
}

