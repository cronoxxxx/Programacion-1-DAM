package org.example.previas.E1.dao;

import org.example.previas.E1.domain.Cliente;
import org.example.previas.E1.domain.Factura;

import java.util.*;

public interface DaoMostrador {
    Set<Factura> getFacturas();
    boolean isEmptyClientes();
    boolean putCliente(int clave, Cliente valor);
    Map<Integer, Cliente> mostrarInformacion(boolean ascendente);
    Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente);


    boolean venderClienteFisico();

    double getBeneficios();
    boolean venderClienteOnline();
    boolean buscarClienteporID(int id);
    boolean buscarClienteNombreApellido(String nombre, String apellidos);
    boolean removeClienteporID(int id);
    boolean removeClienteporNombreApellidos(String nombre, String apellidos);
    boolean aplicarDescuentosClienteporID(int id);
    boolean aplicarDescuentosporClienteNombreApellidos(String nombre, String apellidos);

}
