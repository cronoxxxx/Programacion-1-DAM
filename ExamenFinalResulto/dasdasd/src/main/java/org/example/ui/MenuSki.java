package org.example.ui;

import org.example.common.Constantes;
import org.example.common.DificultadException;
import org.example.dao.DaoFicheros;
import org.example.dao.Pistas;
import org.example.domain.Pista;
import org.example.domain.Pueblo;
import org.example.domain.SkiAlpino;
import org.example.domain.SkiFondo;
import org.example.service.IServiceInterface;
import org.example.service.ServiceInterface;

import java.io.IOException;
import java.util.*;

public class MenuSki {
    public static void action() {
        IServiceInterface serviceInterface = new IServiceInterface();
        int op = 0;
        do {
            System.out.println(Constantes.BIENVENIDO_AL_MENU);
            System.out.println("1. Mostrar pistas");
            System.out.println("2. Mostrar pistas ordenadas");
            System.out.println("3. Añadir pistas");
            System.out.println("4. Consultar extension de km de pistas de una provincia");
            System.out.println("5. Añadir pueblo a la ruta de la pista SkiFondo");
            System.out.println("6. Eliminar pista por ID");
            System.out.println("7. Devolver informacion de pistas por cada provincia");
            System.out.println("8. Salir del programa");
            System.out.println(Constantes.SELECCIONE_UNA_OPCION);
            op = menu();
            switch (op) {
                case 1 -> getPistas(serviceInterface);
                case 2 -> getPistasOrdenadas(serviceInterface);
                case 3 -> addPistas(serviceInterface);
                case 4 -> consultaKmProvincia(serviceInterface);
                case 5 -> agregarPuebloRuta(serviceInterface);
                case 6 -> eliminarPista(serviceInterface);
                case 7 -> devolverInfoPistaPorProvincia(serviceInterface);
                case 8 -> {
                    boolean b = serviceInterface.escribirFichero() && serviceInterface.escribirFicheroBinario();
                    if (b) {
                        serviceInterface.escribirFichero();
                        serviceInterface.escribirFicheroBinario();
                        System.out.println(Constantes.DATOS_GUARDADOS);
                    } else {
                        System.err.println("No se han podido guardar los datos");
                    }

                    System.out.println(Constantes.VUELVA_PRONTO);
                }

                default -> System.out.println("Opcion no valida");

            }
        } while (op != 8);
    }

    private static void devolverInfoPistaPorProvincia(IServiceInterface serviceInterface) {
        Map<String, List<Pista>> mapa = serviceInterface.getPistasProvincia();
        if (mapa != null) {
            for (String provincia : mapa.keySet()) {
                List<Pista> pistasProvincia = mapa.get(provincia);
                int numPistas = pistasProvincia.size();
                double sumKm = 0.0;
                for (Pista pista : pistasProvincia) {
                    sumKm += pista.getKmExtension();
                }
                double mediaKmPorPista = sumKm / numPistas;
                System.out.println("Provincia: " + provincia);
                System.out.println("Pistas: " + pistasProvincia);
                System.out.println("Número de pistas: " + numPistas);
                System.out.println("Media de km por pista: " + mediaKmPorPista);
                System.out.println();
            }
        } else {
            System.out.println("No hay nada para listar");
        }
    }

    private static void eliminarPista(IServiceInterface serviceInterface) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id de la pista ");
        int id = entrada.nextInt();
        if (serviceInterface.removePista(id)) {
            System.out.println("Pista removida con exito");
        } else {
            System.out.println("Pista no removida");
        }
    }

    private static void agregarPuebloRuta(IServiceInterface serviceInterface) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id de la pista de SkiFondo");
        int id = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese el pueblo a agregar");
        String prov = entrada.nextLine();
        Pueblo p = new Pueblo(prov);
        if (serviceInterface.addPuebloListaPueblos(id, p)) {
            System.out.println("Pueblo añadido con exito");
        } else {
            System.out.println("Pueblo no añadido");
        }

    }


    private static void consultaKmProvincia(IServiceInterface serviceInterface) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la provincia");
        String prov = entrada.nextLine();
        if (serviceInterface.consulta(prov) != -1) {
            System.out.println("Suma de km ->" + serviceInterface.consulta(prov));
        } else {
            System.out.println("Cantidad vacia");
        }

    }


    private static void addPistas(IServiceInterface serviceInterface) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduzca que tipo de pista desea agregar:");
        System.out.println("1. SkiAlpino 2. Skifondo");
        int op = menu();
        if (op == 1) {
            System.out.println("Ingrese el nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese la provincia");
            String prov = entrada.nextLine();
            System.out.println("Ingrese los km de extension");
            double km = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Ingrese la dificultad media");
            String dif = entrada.nextLine();
            SkiAlpino s = null;
            try {
                s = new SkiAlpino(nombre, prov, km, dif);
            } catch (DificultadException e) {
                e.printStackTrace(System.out);
            }
            if (serviceInterface.addPista(s)) {
                System.out.println("Añadido con exito");
            } else {
                System.out.println("Añadido fallido");
            }
        } else if (op == 2) {
            System.out.println("Ingrese el nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese la provincia");
            String prov = entrada.nextLine();
            System.out.println("Ingrese los km de extension");
            double km = entrada.nextDouble();
            entrada.nextLine();
            System.out.println("Cuantos pueblos contiene?");
            List<String> p = new ArrayList<>();
            int cant = entrada.nextInt();
            entrada.nextLine();
            for (int i = 0; i < cant; i++) {
                System.out.println("Ingrese la provincia Nº" + (i + 1));
                String pueblo = entrada.nextLine();
                p.add(pueblo);
            }
            SkiFondo s = new SkiFondo(nombre, prov, km, p);
            if (serviceInterface.addPista(s)) {
                System.out.println("Añadido con exito");
            } else {
                System.out.println("Añadido fallido");
            }
        } else {
            System.out.println("Opcion no valida");
        }

    }

    private static void getPistasOrdenadas(IServiceInterface serviceInterface) {
        System.out.println("Introduzca por que orden desea: ");
        System.out.println("1. Ascendente 2. Descendente");
        int op = menu();
        if (op == 1) {
            if (serviceInterface.listadoOrdenadoProvinciaKm(true) != null) {
                serviceInterface.listadoOrdenadoProvinciaKm(true).forEach(System.out::println);
            } else {
                System.out.println("La lista esta vacia");
            }

        } else if (op == 2) {
            if (serviceInterface.listadoOrdenadoProvinciaKm(false) != null) {
                serviceInterface.listadoOrdenadoProvinciaKm(false).forEach(System.out::println);
            } else {
                System.out.println("La lista esta vacia");
            }
        } else {
            System.out.println("Opcion no valida");
        }
    }

    private static void getPistas(IServiceInterface serviceInterface) {
        System.out.println("Lista:");
        if (serviceInterface.getListaPistas() != null) {
            serviceInterface.getListaPistas().forEach(System.out::println);
        } else {
            System.out.println("La lista esta vacia");
        }

    }


    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        int op = 0;
        try {
            op = entrada.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace(System.out);
        }
        return op;
    }
}
