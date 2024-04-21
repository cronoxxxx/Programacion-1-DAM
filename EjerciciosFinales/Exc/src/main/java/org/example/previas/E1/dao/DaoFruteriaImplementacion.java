package org.example.previas.E1.dao;

import org.example.previas.E1.domain.Fruta;

import java.util.List;

public class DaoFruteriaImplementacion implements DaoFruteria{
    @Override
    public List<Fruta> getFrutas() {
        return null;
    }

    @Override
    public boolean isEmptyFrutas() {
        return false;
    }

    @Override
    public List<Fruta> mostrarInformacion(boolean ascendente) {
        return null;
    }

    @Override
    public boolean darAltaFruta(Fruta fruta) {
        return false;
    }

    @Override
    public boolean darBajaFrutaPorNombre(String nombreFruta) {
        return false;
    }

    @Override
    public boolean darBajaFrutasPorProcedencia(String procedencia) {
        return false;
    }

    @Override
    public boolean rebajar(double cantidad, int indexFruta) {
        return false;
    }

    @Override
    public boolean subir(double cantidad, int indexFruta) {
        return false;
    }

    @Override
    public double calcularInventarioTotal() {
        return 0;
    }

    @Override
    public boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta) {
        return false;
    }

    @Override
    public boolean frutasDeMismaProcedencia(String nombre1, String nombre2) {
        return false;
    }

    @Override
    public boolean reunirFrutasporProcedencia() {
        return false;
    }

    @Override
    public boolean buscarFrutaPorNombre(String nombreFruta) {
        return false;
    }

    @Override
    public boolean limpiarFrutasSinContenido() {
        return false;
    }

    @Override
    public boolean removeFrutasSinContenido() {
        return false;
    }
}
