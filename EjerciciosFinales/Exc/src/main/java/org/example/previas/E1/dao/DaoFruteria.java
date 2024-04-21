package org.example.previas.E1.dao;

import org.example.previas.E1.domain.Fruta;

import java.util.List;

public interface DaoFruteria {
    List<Fruta> getFrutas();
    boolean isEmptyFrutas();
    List<Fruta> mostrarInformacion(boolean ascendente);
    boolean darAltaFruta(Fruta fruta);
    boolean darBajaFrutaPorNombre(String nombreFruta);
    boolean darBajaFrutasPorProcedencia(String procedencia);
    boolean rebajar(double cantidad, int indexFruta);
    boolean subir(double cantidad, int indexFruta);
    double calcularInventarioTotal();
    boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta);
    boolean frutasDeMismaProcedencia(String nombre1, String nombre2);
    boolean reunirFrutasporProcedencia();
    boolean buscarFrutaPorNombre(String nombreFruta);
    boolean limpiarFrutasSinContenido();
    boolean removeFrutasSinContenido();

}
