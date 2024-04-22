package org.example.previas.E1.dao;

import org.example.previas.E1.domain.Cliente;
import org.example.previas.E1.domain.Factura;

import java.util.Map;
import java.util.Set;

public class DaoMostradorImplementacion implements DaoMostrador{
    private Mostrador mostrador;

    public DaoMostradorImplementacion() {
        this.mostrador = new Mostrador();
    }


    @Override
    public Set<Factura> getFacturas() {
        return mostrador.getFacturas();
    }
    //JUnit5
    @Override
    public boolean isEmptyClientes() {
        return mostrador.isEmptyClientes();
    }
    //JUnit5
    @Override
    public boolean putCliente(int clave, Cliente valor) {
        return mostrador.putCliente(clave,valor);

    }

    @Override
    public Map<Integer, Cliente> mostrarInformacion(boolean ascendente) {
        return mostrador.mostrarInformacion(ascendente);
    }

    @Override
    public Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente) {
        return mostrador.mostrarInformacionporNombre(ascendente);
    }

    @Override
    public boolean venderClienteFisico() {
        return mostrador.venderClienteFisico();
    }

    @Override
    public double getBeneficios() {
        return mostrador.getBeneficios();
    }

    @Override
    public boolean venderClienteOnline() {
        return mostrador.venderClienteOnline();
    }
    //JUnit5
    @Override
    public boolean buscarClienteporID(int id) {
        return mostrador.buscarClienteporID(id);
    }
    //JUnit5
    @Override
    public boolean buscarClienteNombreApellido(String nombre, String apellidos) {
        return mostrador.buscarClienteNombreApellido(nombre,apellidos);
    }
    //JUnit5
    @Override
    public boolean removeClienteporID(int id) {
        return mostrador.removeClienteporID(id);
    }

    @Override
    public boolean removeClienteporNombreApellidos(String nombre, String apellidos) {
        return mostrador.removeClienteporNombreApellidos(nombre,apellidos);
    }
    //JUnit5
    @Override
    public boolean aplicarDescuentosClienteporID(int id) {
        return mostrador.aplicarDescuentosClienteporID(id);
    }

    @Override
    public boolean aplicarDescuentosporClienteNombreApellidos(String nombre, String apellidos) {
        return mostrador.aplicarDescuentosporClienteNombreApellidos(nombre,apellidos);
    }
}
