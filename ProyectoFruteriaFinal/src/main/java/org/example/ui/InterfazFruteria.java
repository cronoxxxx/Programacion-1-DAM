package org.example.ui;

import org.example.common.Constantes;
import org.example.common.FechaInvalidaException;
import org.example.common.precioVentaExcepcion;
import org.example.domain.Fruta;
import org.example.service.GestionFruteria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class InterfazFruteria {
    private static final String pass = "messi";


    public static void getInterfazFruteria(GestionFruteria gestionFruteria) {
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        Optional<String> contraOptional = Optional.empty();
        System.out.println(Constantes.INGRESE_CONTRASENA);
        try {
            String contra = entradaReader.readLine().strip();
            contraOptional = Optional.of(contra);
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
        if (contraOptional.isPresent() && !contraOptional.get().equals(pass)) {
            System.out.println(Constantes.CONTRASENA_INCORRECTA_INGRESE_UNA_VALIDA);
        } else {
            System.out.println(Constantes.MENU_FRUTERIA);
            int op = menu();
            switch (op) {
                case 1 -> gestionFruteria.mostrarInformacion(true);
                case 2 -> darAltaFruta(gestionFruteria);
                case 3 -> darBajaFruta(gestionFruteria);
                case 4 -> rebajarPrecioFruta(gestionFruteria);
                case 5 -> subirPrecioFruta(gestionFruteria);
                case 6 -> calcularInventarioTotal(gestionFruteria);
                case 7 -> actualizarPrecioVentaFruta(gestionFruteria);
                case 8 -> compararFrutasProcedencia(gestionFruteria);
                case 9 -> reunirFrutasporProcedencia(gestionFruteria);
                case 10 -> buscarFrutaPorNombre(gestionFruteria);

                default -> System.out.println(Constantes.INGRESE_UNA_OPCION_VALIDA);

            }
        }


    }

    public static void calcularInventarioTotal(GestionFruteria gestionFruteria) {
        if (gestionFruteria.calcularInventarioTotal() != -1) {
            System.out.println(Constantes.EL_INVENTARIO_TOTAL_ES + gestionFruteria.calcularInventarioTotal());
        } else {
            System.err.println(Constantes.PRECIOS_DE_VENTA_MAL_INGRESADOS_VERIFICAR_PROGRAMA);
        }
    }


    public static void darAltaFruta(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
            String nombre = entradaReader.readLine();
            System.out.println(Constantes.INGRESE_LA_PROCENDENCIA);
            String procedencia = entradaReader.readLine();
            System.out.println(Constantes.INGRESE_EL_PRECIO_COSTE);
            double precioCoste = Double.parseDouble(entradaReader.readLine());
            System.out.println(Constantes.INGRESE_EL_PRECIO_VENTA);
            double precioVenta = Double.parseDouble(entradaReader.readLine());
            System.out.println(Constantes.INGRESE_LA_FECHA_DE_CADUCIDAD);
            LocalDate fechaCaducidad = LocalDate.parse(entradaReader.readLine());
            Fruta fruta = new Fruta(nombre, procedencia, 1, precioCoste, precioVenta, fechaCaducidad, 200);
            if (gestionFruteria.darAltaFruta(fruta)) {
                System.out.println(Constantes.INGRESO_EXITOSO);

            } else {
                System.out.println(Constantes.INGRESO_FALLIDO);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        } catch (NumberFormatException e) {
            System.out.println(Constantes.DEBE_INGRESAR_UN_NUMERO);
        } catch (DateTimeParseException | FechaInvalidaException e) {
            System.out.println(Constantes.DEBE_INGRESAR_FECHA_VALIDA);
        } catch (precioVentaExcepcion e) {
            System.out.println(Constantes.DEBE_INGRESAR_PRECIO_VENTA_MAYOR_A_PRECIO_COSTE);
        }
    }

    public static void darBajaFruta(GestionFruteria gestionFruteria) {
        int op = 0;
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.MENU_BAJA_FRUTA);
            op = menu();
            switch (op) {
                case 1 -> {
                    System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
                    String nombre = entradaReader.readLine();
                    if (gestionFruteria.darBajaFrutaPorNombre(nombre)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_FALLIDO);
                    }
                }
                case 2 -> {
                    System.out.println(Constantes.INGRESE_LA_PROCENDENCIA);
                    String procedencia = entradaReader.readLine();
                    if (gestionFruteria.darBajaFrutasPorProcedencia(procedencia)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_FALLIDO);
                    }
                }
                default -> System.out.println(Constantes.DEBE_INGRESAR_UNA_OPCION_VALIDA);
            }

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void rebajarPrecioFruta(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.MENU_REBAJAR_FRUTA);
            int op = menu();
            switch (op) {
                case 1 -> {
                    System.out.println(Constantes.INGRESE_EL_INDICE_DE_LA_FRUTA);
                    int indice = Integer.parseInt(entradaReader.readLine());
                    System.out.println(Constantes.INGRESE_LA_CANTIDAD_A_REBAJAR);
                    double cantidad = Double.parseDouble(entradaReader.readLine());
                    if (gestionFruteria.rebajar(cantidad, indice)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_FALLIDO);
                    }
                }
                case 2 -> {
                    System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
                    String nombre = entradaReader.readLine();
                    System.out.println(Constantes.INGRESE_LA_CANTIDAD_A_REBAJAR);
                    double cantidad = Double.parseDouble(entradaReader.readLine());
                    if (gestionFruteria.rebajarNombreFruta(cantidad, nombre)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_FALLIDO);
                    }
                }
                default -> System.out.println(Constantes.DEBE_INGRESAR_UNA_OPCION_VALIDA);
            }

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void subirPrecioFruta(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.MENU_SUBIR_FRUTA);
            int op = menu();
            switch (op) {
                case 1 -> {
                    System.out.println(Constantes.INGRESE_EL_INDICE_DE_LA_FRUTA);
                    int indice = Integer.parseInt(entradaReader.readLine());
                    System.out.println(Constantes.INGRESE_LA_CANTIDAD_A_SUBIR);
                    double cantidad = Double.parseDouble(entradaReader.readLine());
                    if (gestionFruteria.subir(cantidad, indice)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    } else {
                        System.out.println(Constantes.ELIMINADO_FALLIDO);
                    }
                }
                case 2 -> {
                    System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
                    String nombre = entradaReader.readLine();
                    System.out.println(Constantes.INGRESE_LA_CANTIDAD_A_SUBIR);
                    double cantidad = Double.parseDouble(entradaReader.readLine());
                    if (gestionFruteria.subirNombreFruta(cantidad, nombre)) {
                        System.out.println(Constantes.ELIMINADO_EXITOSO);
                    }
                }
                default -> System.out.println(Constantes.DEBE_INGRESAR_UNA_OPCION_VALIDA);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void actualizarPrecioVentaFruta(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
            String nombre = entradaReader.readLine();
            System.out.println(Constantes.INGRESE_LA_CANTIDAD_A_ACTUALIZAR);
            double cantidad = Double.parseDouble(entradaReader.readLine());
            if (gestionFruteria.actualizarPrecioVenta(nombre, cantidad)) {
                System.out.println(Constantes.ELIMINADO_EXITOSO);
            } else {
                System.out.println(Constantes.ELIMINADO_FALLIDO);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void compararFrutasProcedencia(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA + 1);
            String fruta1 = entradaReader.readLine();
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA + 2);
            String fruta2 = entradaReader.readLine();
            if (gestionFruteria.frutasDeMismaProcedencia(fruta1, fruta2)) {
                System.out.println(Constantes.COMPARACION_EXITOSA);
            } else {
                System.out.println(Constantes.COMPARACION_FALLIDA);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void reunirFrutasporProcedencia(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.INGRESE_LA_PROCENDENCIA);
            String procedencia = entradaReader.readLine();
            if (gestionFruteria.reunirFrutasporProcedencia(procedencia)) {
                System.out.println(Constantes.ELIMINADO_EXITOSO);
            } else {
                System.out.println(Constantes.ELIMINADO_FALLIDO);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }

    public static void buscarFrutaPorNombre(GestionFruteria gestionFruteria) {
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(Constantes.INGRESE_EL_NOMBRE_DE_LA_FRUTA);
            String nombre = entradaReader.readLine();
            if (gestionFruteria.buscarFrutaPorNombre(nombre)) {
                System.out.println(Constantes.ENCONTRADO_EXITOSO);
            } else {
                System.out.println(Constantes.ENCONTRADO_FALLIDO);
            }
        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }


    public static int menu() {
        int op = 0;
        boolean valido = false;
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                op = Integer.parseInt(entradaReader.readLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println(Constantes.DEBE_INGRESAR_UN_NUMERO);
            } catch (IOException e) {
                System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
            }
        } while (!valido);

        return op;
    }
}
