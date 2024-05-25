package org.example.service;

import org.example.dao.Database;
import org.example.dao.Mostrador;
import org.example.domain.Cliente;
import org.example.domain.Factura;
import org.example.domain.Fruta;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IGestionMostrador {
    Set<Factura> getFacturas();
    boolean isEmptyClientes();
    boolean putCliente(Cliente valor);
    Map<Integer, Cliente> mostrarInformacion(boolean ascendente);
    Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente);


    boolean venderClienteFisico(Cliente clienteComprador, StringBuilder sb, int ...cantidadKilos);

    double getBeneficios();
    boolean venderClienteOnline(Cliente clienteCompradorOnline, StringBuilder sb, int ...cantidadKilos);
    boolean buscarClienteporID(int id);
    boolean buscarClienteNombreApellido(String nombre, String apellidos);
    boolean removeClienteporID(int id);
    boolean removeClienteporNombreApellidos(Cliente cliente);
    boolean aplicarDescuentosClienteporID(int id);
    boolean aplicarDescuentosporClienteNombreApellidos(Cliente descontar);
    Cliente devolverClienteOnline (int id);
    Cliente devolverClienteFisico ();
    List<Cliente> clienteAccion (String nombre, String apellidos);
    boolean reunirClientesPorCiudad(String ciudad);

    Database leerFicheroBinario();
    boolean escribirFicheroBinario();

    boolean escribirCambiosFrutaTexto();

    List<Fruta> leerCambiosFrutaTexto();

    Set<Factura> buscarFacturasPorFecha(String date);

    boolean actualizarFactura(Factura factura,String nombre, String apellidos);

    Set<Factura> devolverFacturasNombreSet(String nombre, String apellidos);
}
