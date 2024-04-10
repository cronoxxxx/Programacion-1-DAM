package com.example.ejemploahorcado.ui;

import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.common.Comprobacion;
import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.dao.IDException;
import com.example.ejemploahorcado.domain.Palabra;
import com.example.ejemploahorcado.service.GestionPalabras;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase con métodos de administración para consola
 */
public class GestionDiccionario {
    private static final String pass = "messi";

    public static void gestion(GestionPalabras gestionPalabras) throws CategoriaException {
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.INTRODUCE_LA_CONTRASENA);
        String contra = null;
        do {
            contra = entrada.nextLine().strip();
            if (!contra.equals(pass)) {
                System.out.println(Constantes.CONTRASENA_INCORRECTA_INGRESE_UNA_VALIDA);
            }
        } while (!contra.equals(pass));

        if (contra.equals(pass)) {
            System.out.println(Constantes.CONTRASENA_CORRECTA);
            int opcion;
            do {
                opcion = mostrarMenu();
                switch (opcion) {
                    case 1 -> listarOrdenados(gestionPalabras);
                    case 2 -> insertarPalabra(gestionPalabras);
                    case 3 -> modificarIncognitaOrCategoria(gestionPalabras);
                    case 4 -> eliminarPalabra(gestionPalabras);
                    case 5 -> {
                        System.out.println(Constantes.VUELVA_PRONTO);
                        gestionPalabras.escribirFichero2();
                        try {
                            gestionPalabras.leerFichero();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    default -> System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
                }
            } while (opcion != 5);
        }

    }


    public static void listarOrdenados(GestionPalabras gestionPalabras) {
        Scanner entrada = new Scanner(System.in);
        boolean vuelve = false;
        int num;
        System.out.println(Constantes.INTRODUCE_1_PARA_ALISTAR_DE_FORMA_ASCENDENTE_0_2_PARA_DESCENDENTE);
        do {
            try {
                num = entrada.nextInt();
                if (num == 1) {

                    System.out.println(gestionPalabras.listarPalabras(true));
                    vuelve = true;
                } else if (num == 2) {
                    System.out.println(gestionPalabras.listarPalabras(false));
                    vuelve = true;
                } else {
                    System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
                }
            } catch (InputMismatchException in) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                System.out.println(in.getMessage());
                entrada.nextLine();
            }
        } while (!vuelve);
    }

    public static void insertarPalabra(GestionPalabras gestionPalabras) throws CategoriaException {
        Scanner entrada = new Scanner(System.in);
        boolean valorValido = false;
        String categoria = null;
        boolean categoriaValida = false;
        //System.out.println("Ingresa el id de la palabra");
        System.out.println(Constantes.INGRESA_EL_ID_DE_LA_PALABRA);
        int id = 0;
        do {

            try {
                id = entrada.nextInt();
                gestionPalabras.idOK(id);
                valorValido = true;
            } catch (IDException | InputMismatchException i) {
                System.out.println(Constantes.ID_INVALIDO);
                entrada.nextLine();
            }
        } while (!valorValido);
        int level = 0;
        try {
            System.out.println(Constantes.INGRESA_EL_NIVEL_DE_LA_NUEVA_PALABRA);
            level = entrada.nextInt();
        } catch (InputMismatchException in) {
            System.out.println(Constantes.VALOR_INVALIDO);
            entrada.nextLine();
        }
        entrada.nextLine();
        //System.out.println("Ingresa la categoria");
        do {
            System.out.println(Constantes.INGRESA_LA_CATEGORIA);
            try {
                categoria = entrada.nextLine();
                Comprobacion.categoriaOk(categoria);
                categoriaValida = true;
            } catch (CategoriaException e) {
                System.out.println(Constantes.VALOR_INVALIDO + e.getMessage());
                entrada.nextLine();
            }
        } while (!categoriaValida);

        System.out.println(Constantes.INGRESA_LA_INCOGNITA);
        String incognita = entrada.nextLine();
            if (gestionPalabras.insertarPalabra(id, level, incognita, categoria)) {
                System.out.println(Constantes.AGREGADO_CON_EXITO);
            } else {
                System.out.println(Constantes.VALOR_INVALIDO);
            }
    }


    public static void modificarIncognitaOrCategoria(GestionPalabras gestionPalabras) {
        System.out.println(Constantes.MENU_MODIFICAR_INCOGNITA_O_CATEGORIA);
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        boolean valorValido = false;
        do {
            try {
                opcion = entrada.nextInt();
                if (opcion == 1) {
                    System.out.println(Constantes.INGRESA_EL_ID_DE_LA_PALABRA);
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println(Constantes.INGRESA_LA_INCOGNITA);
                    String incognita = entrada.nextLine();
                    if (!gestionPalabras.modificarPalabra(id, incognita)) {
                        System.out.println(Constantes.VALOR_INVALIDO);
                    } else {
                        System.out.println(Constantes.MODIFICADO_CON_EXITO);
                    }
                    valorValido = true;
                } else if (opcion == 2) {
                    System.out.println(Constantes.INGRESA_EL_ID_DE_LA_PALABRA);
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println(Constantes.INGRESA_LA_CATEGORIA);
                    String categoria = entrada.nextLine();
                    if (!gestionPalabras.modificarCategoria(id, categoria)) {
                        System.out.println(Constantes.VALOR_INVALIDO);
                    } else {
                        System.out.println(Constantes.MODIFICADO_CON_EXITO);
                    }
                    valorValido = true;
                } else {
                    System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
                }
            } catch (InputMismatchException | CategoriaException exp) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);

                System.out.println(exp.getMessage());
                entrada.nextLine();
            }
        } while (!valorValido);
    }

    public static void eliminarPalabra(GestionPalabras gestionPalabras) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(Constantes.MENU_ELIMINAR);
        int num = 0;
        boolean vuelve = false;
        int id;
        do {
            try {
                num = entrada.nextInt();
                if (num == 1) {
                    System.out.println(Constantes.INGRESA_EL_ID_DE_LA_PALABRA_A_ELIMINAR);
                    id = entrada.nextInt();
                    if (!gestionPalabras.eliminarPalabra(id)) {
                        System.out.println(Constantes.VALOR_INVALIDO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_CON_EXITO);
                    }
                    vuelve = true;
                } else if (num == 2) {
                    System.out.println(Constantes.INGRESA_EL_ID_DE_LA_PALABRA_A_ELIMINAR);
                    id = entrada.nextInt();
                    System.out.println(Constantes.INGRESA_EL_NIVEL_DE_LA_PALABRA);
                    int nivel = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println(Constantes.INGRESA_LA_INCOGNITA);
                    String incognita = entrada.nextLine();
                    System.out.println(Constantes.INGRESA_LA_CATEGORIA);
                    String categoria = entrada.nextLine();
                    if (gestionPalabras.eliminarPalabra(new Palabra(id, nivel, incognita, categoria))) {
                        System.out.println(Constantes.ELIMINADO_CON_EXITO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_CON_EXITO);
                    }
                    vuelve = true;
                } else {
                    System.out.println(Constantes.SELECCIONA_UNA_OPCION_VALIDA);
                }
            } catch (InputMismatchException | CategoriaException in) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                System.out.println(Constantes.REVISAR_POSIBLE_ID_REPETIDO_O_CATEGORIA_INEXISTENTE);
                entrada.nextLine();
            }
        } while (!vuelve);
    }


    public static int mostrarMenu() {
        Scanner lector = new Scanner(System.in);
        System.out.println(Constantes.MENU + "\n" + Constantes.OPCION1 + "\n" + Constantes.OPCION2 + "\n" + Constantes.OPCION3 + "\n" + Constantes.OPCION4 + "\n" + Constantes.OPCION5);
        int num = 0;
        boolean caracterValido = false;
        do {
            try {
                num = lector.nextInt();
                caracterValido = true;
            } catch (InputMismatchException in) {
                System.out.println(Constantes.CARACTER_NO_VALIDO_SOLO_SE_PERMITEN_NUMEROS_INTRODUZCA_UN_CARACTER_VALIDO);
                System.out.println(in.getMessage());
                lector.nextLine();
            }
        } while (!caracterValido);

        return num;
    }


}
