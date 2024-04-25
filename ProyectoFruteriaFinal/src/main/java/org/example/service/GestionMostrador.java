package org.example.service;

import lombok.Getter;
import org.example.dao.DaoFicherosFruta;
import org.example.dao.DaoMostradorImplementacion;
import org.example.dao.Mostrador;
import org.example.domain.Cliente;
import org.example.domain.Factura;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Getter
public class GestionMostrador implements IGestionMostrador{
    private DaoMostradorImplementacion daoMostradorImplementacion;
    public GestionMostrador() {
        this.daoMostradorImplementacion = new DaoMostradorImplementacion();
    }
    public GestionMostrador(DaoMostradorImplementacion daoMostradorImplementacion) {
        this.daoMostradorImplementacion = daoMostradorImplementacion;
    }
    @Override
    public Set<Factura> getFacturas() {
        return daoMostradorImplementacion.getFacturas();
    }

    @Override
    public boolean isEmptyClientes() {
        return daoMostradorImplementacion.isEmptyClientes();
    }

    @Override
    public boolean putCliente(int clave, Cliente valor) {
        return daoMostradorImplementacion.putCliente(clave, valor);
    }

    @Override
    public Map<Integer, Cliente> mostrarInformacion(boolean ascendente) {
        return daoMostradorImplementacion.mostrarInformacion(ascendente);
    }

    @Override
    public Map<Integer, Cliente> mostrarInformacionporNombre(boolean ascendente) {
        return daoMostradorImplementacion.mostrarInformacionporNombre(ascendente);
    }

    @Override
    public boolean venderClienteFisico(Cliente clienteComprador, StringBuilder sb, int... cantidadKilos) {
        return daoMostradorImplementacion.venderClienteFisico(clienteComprador, sb, cantidadKilos);
    }

    @Override
    public double getBeneficios() {
        return daoMostradorImplementacion.getBeneficios();
    }

    @Override
    public boolean venderClienteOnline(Cliente clienteCompradorOnline, StringBuilder sb, int... cantidadKilos) {
        return daoMostradorImplementacion.venderClienteOnline(clienteCompradorOnline, sb, cantidadKilos);
    }

    @Override
    public boolean buscarClienteporID(int id) {
        return daoMostradorImplementacion.buscarClienteporID(id);
    }

    @Override
    public boolean buscarClienteNombreApellido(String nombre, String apellidos) {
        return daoMostradorImplementacion.buscarClienteNombreApellido(nombre, apellidos);
    }

    @Override
    public boolean removeClienteporID(int id) {
        return daoMostradorImplementacion.removeClienteporID(id);
    }

    @Override
    public boolean removeClienteporNombreApellidos(Cliente cliente) {
        return daoMostradorImplementacion.removeClienteporNombreApellidos(cliente);
    }

    @Override
    public boolean aplicarDescuentosClienteporID(int id) {
        return daoMostradorImplementacion.aplicarDescuentosClienteporID(id);
    }

    @Override
    public boolean aplicarDescuentosporClienteNombreApellidos(Cliente descontar) {
        return daoMostradorImplementacion.aplicarDescuentosporClienteNombreApellidos(descontar);
    }

    @Override
    public Cliente devolverClienteOnline(int id) {
        return daoMostradorImplementacion.devolverClienteOnline(id);
    }

    @Override
    public Cliente devolverClienteFisico() {
        return daoMostradorImplementacion.devolverClienteFisico();
    }

    @Override
    public List<Cliente> clienteAccion(String nombre, String apellidos) {
        return daoMostradorImplementacion.clienteAccion(nombre, apellidos);
    }

    @Override
    public boolean reunirClientesPorCiudad(String ciudad) {
        return daoMostradorImplementacion.reunirClientesPorCiudad(ciudad);
    }

    @Override
    public Mostrador leerFicheroBinario() {
        return DaoFicherosFruta.leerFicheroBinario();
    }

    @Override
    public boolean escribirFicheroBinario(Mostrador mostrador) {
        return DaoFicherosFruta.escribirFicheroBinario(mostrador);
    }
}
