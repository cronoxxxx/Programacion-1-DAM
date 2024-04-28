package org.example.dao;

import lombok.Getter;
import org.example.common.Constantes;
import org.example.domain.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
@Getter
public class Mostrador implements Serializable {
    private final Map<Integer, Cliente> clientesEsperaCompra;
    private final Fruteria fruteria;
    private double beneficios;
    private static int iterador = 1;
    private final Set<Factura> facturas; //No colocará doble factura

    public Mostrador(int cantidad) {
        fruteria = new Fruteria();
        facturas = new TreeSet<>(new Comparators.ComparatorFactura());
        this.clientesEsperaCompra = new HashMap<>();
        for (int i = 0; i < cantidad; i++) {
            int randoMizer = (int) (Math.random() * 2);
            if (randoMizer == 1) {
                clientesEsperaCompra.put(iterador++, new ClienteFisico());
            } else {
                clientesEsperaCompra.put(iterador++, new ClienteOnline());
            }
        }
    }


    public Mostrador() {
        this(20);
    }

    public boolean isEmptyClientes() {
        return clientesEsperaCompra.isEmpty();
    }
    public boolean putCliente(Cliente valor) {
        return clientesEsperaCompra.putIfAbsent(iterador++, valor) == null;
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
                .sorted(ascendente ? Map.Entry.comparingByValue(comparator) : Map.Entry.comparingByValue(comparator.reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap;
    }

    public Cliente devolverClienteFisico() {
        ClienteFisico clienteComprador = null;
        List<Cliente> clientesEnEspera = new LinkedList<>(clientesEsperaCompra.values());
        //Uso del optional
        Optional<Cliente> clienteEncontrado = clientesEnEspera.stream().filter(c -> c instanceof ClienteFisico).filter(c -> ((ClienteFisico) c).getOrdenFila() == iterador).findFirst();
        if (clienteEncontrado.isPresent()) {
            clienteComprador = (ClienteFisico) clienteEncontrado.get();
            System.out.println(Constantes.NOMBRE_DEL_CLIENTE + clienteComprador.getNombre());
            iterador++;
        } else {
            System.out.println(Constantes.CLIENTE_NO_ENCONTRADO);
        }
        return clienteComprador;
    }
    public boolean venderClienteFisico(Cliente clienteComprador, StringBuilder sb, int ...cantidadKilos) {
        List<Fruta> agregarCompraFrutasFactura = new ArrayList<>();
        String nombreFruta = null;
        double sumadorVenta = 0;
        double descuento = 0;
        List<Double> almacenPrecios = new LinkedList<>();

        String nombreFrutasString = sb.toString();
        nombreFrutasString = nombreFrutasString.substring(0, nombreFrutasString.length() - 2); // Eliminar la ultima coma y espacio
        Scanner frutasScanner = new Scanner(nombreFrutasString).useDelimiter("\\s*,\\s*");
        while (frutasScanner.hasNextLine()) {
            nombreFruta = frutasScanner.next();
            boolean frutaEncontrada = false;
            int j =0;
            for (int i = 0; i < fruteria.getFrutas().size(); i++) {
                Fruta fruta = fruteria.getFrutas().get(i);
                if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta.strip())) {

                    // Se encontró la fruta, realizar la venta
                    frutaEncontrada = true;
                    if (fruta.getNumeroKilos() < cantidadKilos[j]) {
                        System.out.println(Constantes.LO_SENTIMOS_SOLO_TENEMOS_ESTA_CANTIDAD_DE_KILOS_PARA+nombreFruta);
                        System.out.println(fruta.getNumeroKilos());
                    } else {
                        double precioUnitario = fruta.getPrecioVentaPorKilo();
                        double precioVentaFruta = precioUnitario * cantidadKilos[j];

                        if (clienteComprador.isHasDescuento()) {
                            descuento =precioVentaFruta * 0.7; // Aplicar descuento del 30%
                            almacenPrecios.add(precioVentaFruta * 0.7);
                            System.out.println(Constantes.DESCUENTO_EN_LECTURA);
                        } else {
                            descuento =precioVentaFruta;
                            almacenPrecios.add(precioVentaFruta);
                            System.out.println(Constantes.NO_DESCUENTO_EN_LECTURA);
                        }

                        fruta.setNumeroKilos(fruta.getNumeroKilos() - cantidadKilos[j]);
                        beneficios += descuento;
                        sumadorVenta += descuento;

                        System.out.println(Constantes.KILOS_VENDIDOS+cantidadKilos[j]);
                        System.out.println(Constantes.NOMBRE_FRUTA+fruta.getNombre());
                        System.out.println(Constantes.TOTAL_EUROS+descuento);
                        agregarCompraFrutasFactura.add(fruta);
                        fruta.setAgregarNumeroVentas();
                    }
                    j++;
                }

            }

            if (!frutaEncontrada) {
                System.out.println(Constantes.FRUTA_NO_DISPONIBLE+nombreFruta);
                return false;
            }
        }
        System.out.println(Constantes.TOTAL_EUROS+ sumadorVenta);
        Factura factura = new Factura(clienteComprador, agregarCompraFrutasFactura, sumadorVenta,almacenPrecios);
        facturas.add(factura);
        // Eliminar al cliente del mapa lambda
        clientesEsperaCompra.entrySet().stream()
                .filter(entry -> entry.getValue().equals(clienteComprador))
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(clientesEsperaCompra::remove);
        return true;
    }

    public Cliente devolverClienteOnline (int id){
        ClienteOnline clienteCompradorOnline = null;
        Cliente cliente = clientesEsperaCompra.get(id);

        if (cliente != null) {
            if (cliente instanceof ClienteOnline) {
                clienteCompradorOnline = (ClienteOnline) cliente;
                return clienteCompradorOnline;
            } else {
                System.err.println(Constantes.NO_EXISTE_CLIENTE_ONLINE_CON_ESA_ID_O_ESA_ID_NO_EXISTE);

            }
        } else {
            System.err.println(Constantes.CLIENTE_NO_ENCONTRADO);

        }
        return null;
    }


    public boolean venderClienteOnline(Cliente clienteCompradorOnline, StringBuilder sb, int ...cantidadKilos) {
        List<Fruta> agregarCompraFrutasFactura = new LinkedList<>();
        double sumadorPrecio = 0;
        double descontado = 0;
        String nombreFrutasString = sb.toString();
        List<Double> almacenPrecios = new LinkedList<>();
        nombreFrutasString = nombreFrutasString.substring(0, nombreFrutasString.length() - 2); // Eliminar la ultima coma y espacio
        Scanner frutasScanner = new Scanner(nombreFrutasString).useDelimiter("\\s*,\\s*");

        while (frutasScanner.hasNextLine()) {
            String nombreFruta = frutasScanner.next();
            boolean frutaEncontrada = false;
            int j = 0;
            for (int i = 0; i < fruteria.getFrutas().size(); i++) {
                Fruta fruta = fruteria.getFrutas().get(i);

                if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta.strip())) {
                    // Se encontró la fruta, realizar la venta
                    frutaEncontrada = true;

                    if (fruta.getNumeroKilos() < cantidadKilos[j]) {
                        System.out.println(Constantes.LO_SENTIMOS_SOLO_TENEMOS_ESTA_CANTIDAD_DE_KILOS_PARA+nombreFruta);
                        System.out.println(fruta.getNumeroKilos());

                    } else {
                        double precioUnitario = fruta.getPrecioVentaPorKilo();
                        double precioVentaFruta = precioUnitario * cantidadKilos[j];

                        if (clienteCompradorOnline.isHasDescuento()) {
                            descontado = precioVentaFruta * 0.7; // Aplicar descuento del 30%
                            almacenPrecios.add(precioVentaFruta * 0.7);
                            System.out.println(Constantes.DESCUENTO_EN_LECTURA);
                        } else {
                            descontado = precioVentaFruta;
                            almacenPrecios.add(precioVentaFruta);
                            System.out.println(Constantes.NO_DESCUENTO_EN_LECTURA);
                        }

                        fruta.setNumeroKilos(fruta.getNumeroKilos() - cantidadKilos[j]);
                        agregarCompraFrutasFactura.add(fruta);
                        beneficios += descontado;
                        sumadorPrecio += descontado;
                        System.out.println(Constantes.KILOS_VENDIDOS+cantidadKilos[j]);
                        System.out.println(Constantes.NOMBRE_FRUTA+fruta.getNombre());
                        System.out.println(Constantes.TOTAL_EUROS+descontado);
                        fruta.setAgregarNumeroVentas(); // Incrementar el contador de ventas
                    }
                    j++;
                }
            }
            if (!frutaEncontrada) {
                System.out.println(Constantes.FRUTA_NO_DISPONIBLE+nombreFruta);
                return false;
            }
        }
        //Se agrega la factura con los datos puestos

        Factura factura = new Factura(clienteCompradorOnline, agregarCompraFrutasFactura, sumadorPrecio,almacenPrecios);
        facturas.add(factura);
        System.out.println("Total a pagar: " + sumadorPrecio);
        // Eliminar al cliente del mapa
        clientesEsperaCompra.entrySet().stream()
                .filter(entry -> entry.getValue().equals(clienteCompradorOnline))
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(clientesEsperaCompra::remove);
        return true;
    }
    public boolean buscarClienteporID(int id) {
        Cliente cliente = clientesEsperaCompra.get(id);
        if (cliente != null) {
            System.out.println(Constantes.CLIENTE_ENCONTRADO_EXITO);
            System.out.println(cliente);
            return true;
        } else {
            System.out.println(Constantes.CLIENTE_NO_ENCONTRADO);
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
            System.out.println(Constantes.CLIENTES_ENCONTRADOS);
            clienteFisico.forEach(System.out::println);
        } else {
            System.out.println(Constantes.CLIENTES_NO_ENCONTRADOS);
        }

        return clienteEncontrado;
    }

    public boolean reunirClientesPorCiudad(String ciudad) {
        Map<String, List<ClienteOnline>> clientesPorCiudad = clientesEsperaCompra.values().stream().filter(cliente -> cliente instanceof ClienteOnline)
                .map(cliente -> (ClienteOnline) cliente).collect(Collectors.groupingBy(ClienteOnline::getCiudad));
        if (!clientesPorCiudad.isEmpty() && clientesPorCiudad.containsKey(ciudad)) {
            System.out.println(Constantes.CLIENTES_DE_LA_CIUDAD+ciudad);
            System.out.println(Constantes.SEPARADOR);
            clientesPorCiudad.get(ciudad).forEach(System.out::println);
            return true;
        } else {
            System.out.println(Constantes.NO_SE_HAN_ENCONTRADO_CLIENTES_EN_LA_CIUDAD+ciudad);
        }
        return false;
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
//this

    public List<Cliente>clienteAccion (String nombre, String apellidos){
        return clientesEsperaCompra.values().stream()
                .filter(cliente -> cliente.getNombre().strip().equalsIgnoreCase(nombre) &&
                        cliente.getApellidos().strip().equalsIgnoreCase(apellidos)).toList();
    }

    public boolean removeClienteporNombreApellidos(Cliente clienteAEliminar){
        if (clienteAEliminar!=null){
            clientesEsperaCompra.entrySet().stream().filter(entry -> entry.getValue().equals(clienteAEliminar))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .ifPresent(clientesEsperaCompra::remove);
            return true;
        }
        return false;
    }


    public boolean aplicarDescuentosClienteporID(int id) {
        Cliente clienteAplicarDescuento = clientesEsperaCompra.get(id);
        if (clienteAplicarDescuento != null) {
            if (!clienteAplicarDescuento.isHasDescuento()) {
                clienteAplicarDescuento.setHasDescuento(true);
            } else {
                System.err.println( Constantes.ESTE_CLIENTE_YA_CUENTA_CON_UN_DESCUENTO+ clienteAplicarDescuento.getNombre() + clienteAplicarDescuento.getApellidos());
                return false;
            }
        } else {
            System.err.println(Constantes.EL_ID_NO_EXISTE);
            return false;
        }
        return true;
    }

    //this
    public boolean aplicarDescuentosporClienteNombreApellidos(Cliente clienteADescontar) {
        boolean aplicado = false;
        if (clienteADescontar != null) {
            if (!clienteADescontar.isHasDescuento()) {
                clienteADescontar.setHasDescuento(true); // Aplicar descuento al cliente seleccionado
                aplicado = true;
            }  else {
                System.err.println( Constantes.ESTE_CLIENTE_YA_CUENTA_CON_UN_DESCUENTO+ clienteADescontar.getNombre() + clienteADescontar.getApellidos());
            }
            System.out.println(Constantes.DESCUENTO_APLICADO_AL_CLIENTE + clienteADescontar.getNombre() + " " + clienteADescontar.getApellidos());
        } else {
            System.out.println(Constantes.OPCION_NO_VALIDA);
        }
        return aplicado;
    }

    public void eliminarTodo(){
        clientesEsperaCompra.clear();
    }
    }

