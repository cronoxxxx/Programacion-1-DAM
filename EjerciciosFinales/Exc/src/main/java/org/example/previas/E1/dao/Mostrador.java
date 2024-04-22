package org.example.previas.E1.dao;

import lombok.Getter;
import org.example.previas.E1.common.Constantes;
import org.example.previas.E1.domain.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.*;
@Getter
public class Mostrador implements Serializable {
    private final Map<Integer, Cliente> clientesEsperaCompra;
    private Fruteria fruteria;
    private double beneficios;
    private int iterador = 1;
    private Set<Factura> facturas; //No colocará doble factura


    private void setIterador() {
        this.iterador = iterador + 1;
    }

    public Mostrador(int cantidad) {
        fruteria = new Fruteria();
        facturas = new TreeSet<>(new Comparators.ComparatorFactura());
        this.clientesEsperaCompra = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            int randoMizer = (int) (Math.random() * 2);
            if (randoMizer == 1) {
                clientesEsperaCompra.put(i + 1, new ClienteFisico());
            } else {
                clientesEsperaCompra.put(i + 1, new ClienteOnline());
            }
        }
    }
    public Mostrador() {
        this(20);
    }

    public boolean isEmptyClientes() {
        return clientesEsperaCompra.isEmpty();
    }



    public boolean putCliente(int clave, Cliente valor) {
        return clientesEsperaCompra.putIfAbsent(clave, valor) == null;
    }

    public Map<Integer, Cliente> mostrarInformacion(boolean ascendente) {
        Map<Integer, Cliente> sortedMap = clientesEsperaCompra.entrySet()
                .stream()
                .sorted(ascendente ? Map.Entry.comparingByKey() : Map.Entry.<Integer, Cliente>comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedMap;
    }

    public Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente) {
        Comparator<Cliente> comparator = new Comparators.ComparatorCliente().thenComparing(Cliente::getApellidos);
        // Comparador para ordenar por nombre y luego por procedencia
        Map<Integer, Cliente> sortedMap = clientesEsperaCompra.entrySet().stream()
                .sorted(ascendente ?
                        Map.Entry.comparingByValue(comparator) : Map.Entry.comparingByValue(comparator.reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap;
    }


    public boolean venderClienteFisico() {
        List<Fruta> agregarCompraFrutasFactura = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        String nombreFruta = null;
        double precioVenta = 0;
        double sumadorVenta = 0;

        ClienteFisico clienteComprador = null;
        for (Cliente cliente : clientesEsperaCompra.values()) {
            if (cliente instanceof ClienteFisico clienteFisico) {
                if (clienteFisico.getOrdenFila() == iterador) {
                    clienteComprador = clienteFisico;
                    System.out.println("Nombre del cliente" + clienteComprador.getNombre());
                    setIterador();
                    break;
                }
            }
        }
        if (clienteComprador == null) {
            System.out.println("El cliente físico no existe.");
            return false;
        }

        System.out.println("Ingrese la cantidad de frutas que desea comprar");
        int cantidadFrutas = entrada.nextInt();
        entrada.nextLine();

// Construyo un separador de comas para separar los nombres
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadFrutas; i++) {
            System.out.println("Ingrese el nombre de la fruta " + (i + 1) + ":");
            nombreFruta = entrada.nextLine();
            sb.append(nombreFruta).append(", ");
        }
        String nombreFrutasString = sb.toString();
        nombreFrutasString = nombreFrutasString.substring(0, nombreFrutasString.length() - 2); // Eliminar la ultima coma y espacio
        Scanner frutasScanner = new Scanner(nombreFrutasString).useDelimiter("\\s*,\\s*");
        while (frutasScanner.hasNextLine()) {
            nombreFruta = frutasScanner.next();
            boolean frutaEncontrada = false;
            for (Fruta fruta : fruteria.getFrutas()) {
                if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta.strip())) {
                    // Se encontró la fruta, realizar la venta
                    frutaEncontrada = true;
                    int cantidadKilos = 0;
                    do {
                        System.out.println("Ingrese la cantidad de kilos de " + fruta.getNombre() + " que desea comprar:");
                        cantidadKilos = entrada.nextInt();
                        if (fruta.getNumeroKilos() < cantidadKilos) {
                            System.out.println("Lo sentimos, solo tenemos " + fruta.getNumeroKilos() + " kilos de " + fruta.getNombre() + " disponibles.");
                        }
                    } while (fruta.getNumeroKilos() < cantidadKilos);
                    // agregarCompraFrutasFactura.add(fruta);
                    precioVenta = fruta.getPrecioVentaPorKilo() * cantidadKilos;
                    if (clienteComprador.isHasDescuento()) {
                        precioVenta *= 0.7; // Aplicar descuento del 30%
                        System.out.println("Hay descuento en lectura");
                    } else {
                        System.out.println("No hay descuento en lectura");
                    }
                    fruta.setNumeroKilos(fruta.getNumeroKilos() - cantidadKilos);
                    beneficios += precioVenta;
                    sumadorVenta += precioVenta;
                    agregarCompraFrutasFactura.add(fruta);
                    System.out.println("Se ha vendido " + cantidadKilos + " kilos de " + fruta.getNombre() + " por un total de " + precioVenta + " euros.");
                    break;
                }
            }

            if (!frutaEncontrada) {
                System.out.println("La fruta '" + nombreFruta + "' no está disponible en la frutería.");
                return false;
            }
        }
        System.out.println("Total a pagar: " + sumadorVenta);
        Factura factura = new Factura(clienteComprador, agregarCompraFrutasFactura, sumadorVenta);
        facturas.add(factura);
        // Eliminar al cliente del mapa lambda
        Cliente clienteFinal = clienteComprador;
        clientesEsperaCompra.entrySet().stream()
                .filter(entry -> entry.getValue().equals(clienteFinal))
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(idCliente -> clientesEsperaCompra.remove(idCliente));
        return true;
    }


    public boolean venderClienteOnline() {
        Scanner entrada = new Scanner(System.in);
        ClienteOnline clienteCompradorOnline = null;
        List<Fruta> agregarCompraFrutasFactura = new ArrayList<>();
        double precioVenta = 0;
        System.out.println("Ingrese la clave del cliente online");
        int id = entrada.nextInt();
        double sumadorPrecio = 0;
        Cliente cliente = clientesEsperaCompra.get(id);

        if (cliente != null) {
            if (cliente instanceof ClienteOnline) {
                clienteCompradorOnline = (ClienteOnline) cliente;
            } else {
                System.err.println("No existe un cliente online con esa id o esa id no existe");
                return false;
            }
        } else {
            System.err.println("El cliente no existe");
            return false;
        }

        System.out.println("Ingrese la cantidad de frutas que el cliente desea comprar");
        int cantidadFrutas = entrada.nextInt();
        entrada.nextLine();

// Construyo un separador de comas para separar los nombres
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadFrutas; i++) {
            System.out.println("Ingrese el nombre de la fruta " + (i + 1) + ":");
            String nombreFruta = entrada.nextLine();
            sb.append(nombreFruta).append(", ");
        }
        String nombreFrutasString = sb.toString();
        nombreFrutasString = nombreFrutasString.substring(0, nombreFrutasString.length() - 2); // Eliminar la ultima coma y espacio
        Scanner frutasScanner = new Scanner(nombreFrutasString).useDelimiter("\\s*,\\s*");
        while (frutasScanner.hasNextLine()) {
            String nombreFruta = frutasScanner.next();
            boolean frutaEncontrada = false;
            for (Fruta fruta : fruteria.getFrutas()) {
                if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta.strip())) {
                    // Se encontró la fruta, realizar la venta
                    frutaEncontrada = true;
                    int cantidadKilos = 0;
                    do {
                        System.out.println("Ingrese la cantidad de kilos de " + fruta.getNombre() + " que desea comprar:");
                        cantidadKilos = entrada.nextInt();
                        if (fruta.getNumeroKilos() < cantidadKilos) {
                            System.out.println("Lo sentimos, solo tenemos " + fruta.getNumeroKilos() + " kilos de " + fruta.getNombre() + " disponibles.");
                        }
                    } while (fruta.getNumeroKilos() < cantidadKilos);
                    agregarCompraFrutasFactura.add(fruta);
                    precioVenta = fruta.getPrecioVentaPorKilo() * cantidadKilos;
                    if (clienteCompradorOnline.isHasDescuento()) {
                        precioVenta *= 0.7; // Aplicar descuento del 30%
                        System.out.println("Hay descuento en lectura");
                    } else {
                        System.out.println("No hay descuento en lectura");
                    }
                    fruta.setNumeroKilos(fruta.getNumeroKilos() - cantidadKilos);
                    beneficios += precioVenta;
                    sumadorPrecio += precioVenta;
                    System.out.println("Se ha vendido " + cantidadKilos + " kilos de " + fruta.getNombre() + " por un total de " + precioVenta + " euros.");
                    break;
                }
            }
            if (!frutaEncontrada) {
                System.out.println("La fruta '" + nombreFruta + "' no está disponible en la frutería.");
                return false;
            }
        }
        //Se agrega la factura con los datos puestos
        Factura factura = new Factura(clienteCompradorOnline, agregarCompraFrutasFactura, sumadorPrecio);
        facturas.add(factura);
        System.out.println("Total a pagar: " + sumadorPrecio);
        // Eliminar al cliente del mapa
        Cliente clienteFinal = clienteCompradorOnline;
        clientesEsperaCompra.entrySet().stream()
                .filter(entry -> entry.getValue().equals(clienteFinal))
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(clientesEsperaCompra::remove);
        return true;
    }


    public boolean buscarClienteporID(int id) {
        Cliente cliente = clientesEsperaCompra.get(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado con exito");
            System.out.println(cliente);
            return true;
        }
        return false;
    }

    public boolean buscarClienteNombreApellido(String nombre, String apellidos) {
        boolean clienteEncontrado = false;
        List<Cliente> clienteFisico = new ArrayList<>();

        for (Cliente cliente : clientesEsperaCompra.values()) {
            // Verificar si el nombre y el apellido coinciden
            if (cliente.getNombre().equalsIgnoreCase(nombre) && cliente.getApellidos().equalsIgnoreCase(apellidos)) {
                clienteFisico.add(cliente);
                clienteEncontrado = true;
            }
        }

        if (clienteEncontrado) {
            System.out.println("Cliente/s encontrado/s:");
            clienteFisico.forEach(System.out::println);
        } else {
            System.out.println("Cliente/s no encontrado/s.");
        }

        return clienteEncontrado;
    }

    public boolean removeClienteporID(int id) {
        Cliente cliente = clientesEsperaCompra.get(id);
        if (cliente != null) {
            clientesEsperaCompra.entrySet().stream().filter(entry -> entry.getValue().equals(cliente))
                    .map(Map.Entry::getKey).findFirst().ifPresent(clientesEsperaCompra::remove);
            return true;
        }
        return false;
    }

    public boolean removeClienteporNombreApellidos(String nombre, String apellidos) {
        List<Cliente> clientesConNombreApellidos = clientesEsperaCompra.values().stream()
                .filter(cliente -> cliente.getNombre().strip().equalsIgnoreCase(nombre) &&
                        cliente.getApellidos().strip().equalsIgnoreCase(apellidos)).toList();

        if (!clientesConNombreApellidos.isEmpty()) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("Se han encontrado los siguientes clientes:");
            for (int i = 0; i < clientesConNombreApellidos.size(); i++) {
                System.out.println(i + 1 + ". " + clientesConNombreApellidos.get(i));
            }

            System.out.println("Por favor, seleccione el cliente que desea eliminar (ingrese el número correspondiente):");
            int opcion = entrada.nextInt();
            if (opcion >= 1 && opcion <= clientesConNombreApellidos.size()) {
                Cliente clienteAEliminar = clientesConNombreApellidos.get(opcion - 1);
                entrada.nextLine();
                clientesEsperaCompra.entrySet().stream().filter(entry -> entry.getValue().equals(clienteAEliminar))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .ifPresent(clientesEsperaCompra::remove);
            } else {
                System.out.println("La opción seleccionada no es válida.");
            }
        } else {
            System.out.println("No se encontraron clientes con el nombre y apellidos proporcionados.");
        }
        return false;
    }

    public boolean aplicarDescuentosClienteporID(int id) {
        Cliente clienteAplicarDescuento = clientesEsperaCompra.get(id);
        if (clienteAplicarDescuento != null) {
            if (!clienteAplicarDescuento.isHasDescuento()) {
                clienteAplicarDescuento.setHasDescuento(true);
            } else {
                System.err.println( Constantes.ESTECLIENTEYACUENTACONUNDESCUENTO+ clienteAplicarDescuento.getNombre() + clienteAplicarDescuento.getApellidos());
                return false;
            }
        } else {
            System.err.println(Constantes.ELIDNOEXISTE);
            return false;
        }
        return true;
    }

    public boolean aplicarDescuentosporClienteNombreApellidos(String nombre, String apellidos) {
        boolean aplicado = false;
        Scanner entrada = new Scanner(System.in);
        List<Cliente> clientesConNombreApellidos = clientesEsperaCompra.values().stream()
                .filter(cliente -> cliente.getNombre().strip().equalsIgnoreCase(nombre) &&
                        cliente.getApellidos().strip().equalsIgnoreCase(apellidos))
                .toList();

        if (!clientesConNombreApellidos.isEmpty()) {
            System.out.println("Se han encontrado los siguientes clientes:");
            System.out.println(Constantes.SEPARADOR);
            for (int i = 0; i < clientesConNombreApellidos.size(); i++) {
                System.out.println(i + 1 + ". " + clientesConNombreApellidos.get(i));
            }
            System.out.println("Ingrese el id al que desea aplicar descuento:");
            int opcion = entrada.nextInt();
            if (opcion >= 1 && opcion <= clientesConNombreApellidos.size()) {
                Cliente clienteADescontar = clientesConNombreApellidos.get(opcion - 1);
                entrada.nextLine();
                clienteADescontar.setHasDescuento(true); // Aplicar descuento al cliente seleccionado
                aplicado = true;
                System.out.println("Descuento aplicado al cliente: " + clienteADescontar.getNombre() + " " + clienteADescontar.getApellidos());
            } else {
                System.out.println("La opción seleccionada no es válida.");
            }
        }
        return aplicado;
    }
}
