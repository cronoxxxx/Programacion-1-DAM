package org.example.ui;

import org.example.common.*;
import org.example.domain.*;
import org.example.service.GestionMostrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class InterfazMostrador  {

    private static final String pass = "ronaldo";
    public static void getInterfazMostrador(GestionMostrador gestionMostrador) {
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        Optional<String> contraOptional = Optional.empty();
        System.out.println(Constantes.INGRESE_CONTRASENA);
        try {
            String contra = entradaReader.readLine().strip();
            contraOptional = Optional.of(contra);
        } catch (IOException ignored) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
        if (contraOptional.isPresent() && !contraOptional.get().equals(pass)) {
            System.out.println(Constantes.CONTRASENA_INCORRECTA_INGRESE_UNA_VALIDA);
        } else {
            int op;
            do {
                System.out.println(Constantes.MENU_MOSTRADOR);
                op = menu();
                switch (op) {
                    case 1 -> mostrarInformacion(gestionMostrador);
                    case 2 -> realizarVentaCliente(gestionMostrador);
                }
            } while (op != 0);
        }
    }


    public static void realizarVentaCliente(GestionMostrador gestionMostrador) {
        StringBuilder sb = new StringBuilder();
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Constantes.SELECCIONE_QUE_CLIENTE_VENDER);
        try {
            int op = menu();
            switch (op) {
                case 1 -> {
                    Cliente fisico = gestionMostrador.devolverClienteFisico();
                    if (fisico != null) {
                        System.out.println(Constantes.INGRESE_CUANTAS_FRUTAS_DESEA_VENDER);
                        int cant = Integer.parseInt(entradaReader.readLine());
                        int[] cantidades = new int[cant];
                        for (int i = 0; i < cant; i++) {
                            System.out.println(Constantes.INGRESE_LA_FRUTA + (i + 1));
                            sb.append(entradaReader.readLine()).append(", ");
                            cantidades[i] = Integer.parseInt(entradaReader.readLine());
                        }

                        //sb.delete(sb.length() - 2, sb.length());
                        if (gestionMostrador.venderClienteFisico(fisico, sb, cantidades)) {
                            System.out.println(Constantes.OPERACION_EXITOSA);
                        } else {
                            System.out.println(Constantes.OPERACION_FALLIDA);
                        }
                    } else {
                        System.out.println(Constantes.CLIENTE_VACIO);
                    }
                }
                case 2 -> {
                    System.out.println(Constantes.SELECCIONE_POR_ID_O_NOMBRE_APELLIDO);
                    op = menu();
                    switch (op) {
                        case 1 -> {
                            System.out.println(Constantes.INGRESE_ID_DEL_CLIENTE);
                            int id = Integer.parseInt(entradaReader.readLine());
                            Cliente online = gestionMostrador.devolverClienteOnline(id);
                            if (online != null) {
                                System.out.println(Constantes.INGRESE_CUANTAS_FRUTAS_DESEA_VENDER);
                                int cant = Integer.parseInt(entradaReader.readLine());
                                int[] cantidades = new int[cant];
                                for (int i = 0; i < cant; i++) {
                                    System.out.println(Constantes.INGRESE_LA_FRUTA + (i + 1));
                                    sb.append(entradaReader.readLine()).append(", ");
                                    cantidades[i] = Integer.parseInt(entradaReader.readLine());
                                }
                                if (gestionMostrador.venderClienteOnline(online, sb, cantidades)) {
                                    System.out.println(Constantes.OPERACION_EXITOSA);
                                } else {
                                    System.out.println(Constantes.OPERACION_FALLIDA);
                                }
                            } else {
                                System.out.println(Constantes.CLIENTE_VACIO);
                            }
                        }
                        case 2 -> {
                            System.out.println(Constantes.INGRESE_NOMBRE_DEL_CLIENTE);
                            String nombre = entradaReader.readLine();
                            System.out.println(Constantes.INGRESE_APELLIDO_DEL_CLIENTE);
                            String apellidos = entradaReader.readLine();
                            List<Cliente> clientes = gestionMostrador.clienteAccion(nombre, apellidos);
                            if (!clientes.isEmpty()) {
                                for (int i = 0; i < clientes.size(); i++) {
                                    System.out.println(i + 1 + ". " + clientes.get(i).getNombre());
                                }
                                System.out.println(Constantes.SELECCIONE_QUE_CLIENTE_VENDER);
                                int index = Integer.parseInt(entradaReader.readLine()) - 1;
                                Cliente online = clientes.get(index);
                                if (online != null) {
                                    System.out.println(Constantes.INGRESE_CUANTAS_FRUTAS_DESEA_VENDER);
                                    int cant = Integer.parseInt(entradaReader.readLine());
                                    int[] cantidades = new int[cant];
                                    for (int i = 0; i < cant; i++) {
                                        System.out.println(Constantes.INGRESE_LA_FRUTA + (i + 1));
                                        sb.append(entradaReader.readLine()).append(", ");
                                        cantidades[i] = Integer.parseInt(entradaReader.readLine());
                                    }
                                    if (gestionMostrador.venderClienteOnline(online, sb, cantidades)) {
                                        System.out.println(Constantes.OPERACION_EXITOSA);
                                    } else {
                                        System.out.println(Constantes.OPERACION_FALLIDA);
                                    }
                                } else {
                                    System.out.println(Constantes.CLIENTE_VACIO);
                                }
                            } else {
                                System.out.println(Constantes.CLIENTE_VACIO);
                            }
                        }
                        default -> System.out.println(Constantes.OPCION_NO_VALIDA);
                    }
                }
            }
            } catch(IOException ignored){
                System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
            }
        }



    private static void darAlta(GestionMostrador gestionMostrador) {
        BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(Constantes.QUE_CLIENTE_DAR_ALTA);
            int op = menu();
            switch (op) {
                case 1->{
                    System.out.println(Constantes.INGRESE_EL_NOMBRE_DEL_CLIENTE);
                    String nombre = entradaReader.readLine();
                    System.out.println(Constantes.INGRESE_SUS_APELLIDOS);
                    String apellidos = entradaReader.readLine();
                    System.out.println(Constantes.SE_DESEA_AGREGA_DESCUENTO_AL_CLIENTE);
                    boolean descuento = false;
                    String respuesta;
                    do {
                        respuesta = entradaReader.readLine();
                        if (!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no"))) {
                            System.out.println(Constantes.ERROR_SOLO_SE_ACEPTAN_VALORES_SI_O_NO);
                        } else descuento = respuesta.strip().equalsIgnoreCase("si");
                    } while (!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")));
                    Cliente fisico = new ClienteFisico(nombre, apellidos, descuento);
                    gestionMostrador.putCliente(fisico);
                }
                case 2->{
                    System.out.println(Constantes.INGRESE_EL_NOMBRE_DEL_CLIENTE);
                    String nombre = entradaReader.readLine();
                    System.out.println(Constantes.INGRESE_SUS_APELLIDOS);
                    String apellidos = entradaReader.readLine();
                    System.out.println(Constantes.SE_DESEA_AGREGA_DESCUENTO_AL_CLIENTE);
                    boolean descuento = false;
                    String respuesta;
                    do {
                        respuesta = entradaReader.readLine();
                        if (!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no"))) {
                            System.out.println(Constantes.ERROR_SOLO_SE_ACEPTAN_VALORES_SI_O_NO);
                        } else descuento = respuesta.strip().equalsIgnoreCase("si");
                    } while (!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")));
                    System.out.println(Constantes.INGRESE_LA_FECHA_DE_ENTREGA);
                    String fechaCaducidadStr = entradaReader.readLine();
                    LocalDate fechaCaducidad = LocalDate.parse(fechaCaducidadStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    System.out.println(Constantes.INGRESE_LA_DIRECCION_DEL_CLIENTE);
                    String direccion = entradaReader.readLine();
                    System.out.println(Constantes.INGRESE_LA_CIUDAD_DEL_CLIENTE);
                    String ciudad = entradaReader.readLine();
                    Cliente online;
                    try {
                        online = new ClienteOnline(nombre, apellidos, fechaCaducidad, direccion, descuento, ciudad);
                        gestionMostrador.putCliente(online);
                    } catch (FechaInvalidaException | DateTimeParseException e) {
                        System.out.println(Constantes.DEBE_INGRESAR_FECHA_VALIDA);
                    } catch (direccionInvalidoException e) {
                        System.out.println(Constantes.DEBE_INGRESAR_FORMATO_DE_DIRECCION_VALIDA);
                    } catch (AgregarProvinciasException e) {
                        System.out.println(Constantes.DEBE_INGRESAR_PROVINCIA_VALIDA);
                    }
                }
                default -> System.out.println(Constantes.INGRESE_UNA_OPCION_VALIDA);
            }

        } catch (IOException e) {
            System.out.println(Constantes.ERROR_ENTRADA_SALIDA);
        }
    }





    public static void mostrarInformacion(GestionMostrador gestionMostrador) {
        System.out.println(Constantes.ORDENAR_MOSTRAR_MOSTRADOR);
        int op = menu();
        switch (op) {
            case 1 ->{
                System.out.println(Constantes.SELECCIONE_ORDEN_DE_MUESTRA);
                op = menu();
                switch (op) {
                    case 1 -> System.out.println(gestionMostrador.mostrarInformacion(true));
                    case 2 -> System.out.println(gestionMostrador.mostrarInformacion(false));
                    default -> System.out.println(Constantes.INGRESE_UNA_OPCION_VALIDA);
                }
            }
            case 2 ->{
                System.out.println(Constantes.SELECCIONE_ORDEN_DE_MUESTRA);
                op = menu();
                switch (op) {
                    case 1 -> System.out.println(gestionMostrador.mostrarInformacionporNombre(true));
                    case 2 -> System.out.println(gestionMostrador.mostrarInformacionporNombre(false));
                    default -> System.out.println(Constantes.INGRESE_UNA_OPCION_VALIDA);
                }
            }
            default -> System.out.println(Constantes.INGRESE_UNA_OPCION_VALIDA);
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
