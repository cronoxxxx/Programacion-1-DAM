package org.example.previas.E1.dao;

import org.example.previas.E1.domain.Cliente;

import java.util.Map;

public class DaoMostradorImplementacion implements DaoMostrador{

    @Override
    public boolean isEmptyClientes() {
        return false;
    }

    @Override
    public boolean putCliente(int clave, Cliente valor) {
        return false;
    }

    @Override
    public Map<Integer, Cliente> mostrarInformacion(boolean ascendente) {
        return null;
    }

    @Override
    public Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente) {
        return null;
    }

    @Override
    public boolean venderClienteFisico(int numeroKilosVenta, String nombreFruta) {
        return false;
    }

    @Override
    public double getBeneficios() {
        return 0;
    }

    @Override
    public boolean venderClienteOnline() {
        return false;
    }

    @Override
    public boolean buscarClienteporID(int id) {
        return false;
    }

    @Override
    public boolean buscarClienteNombreApellido(String nombre, String apellidos) {
        return false;
    }

    @Override
    public boolean removeClienteporID(int id) {
        return false;
    }

    @Override
    public boolean removeClienteporNombreApellidos(String nombre, String apellidos) {
        return false;
    }

    @Override
    public boolean aplicarDescuentosClienteporID(int id) {
        return false;
    }

    @Override
    public boolean aplicarDescuentosporClienteNombreApellidos(String nombre, String apellidos) {
        return false;
    }
}
