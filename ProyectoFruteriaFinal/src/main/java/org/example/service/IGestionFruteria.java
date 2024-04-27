package org.example.service;

import org.example.domain.Fruta;

import java.io.FileNotFoundException;
import java.util.List;

public interface IGestionFruteria {
    List<Fruta> getFrutas();
    boolean isEmptyFrutas();
    List<Fruta> mostrarInformacion(boolean ascendente);
    boolean darAltaFruta(Fruta fruta);
    boolean darBajaFrutaPorNombre(String nombreFruta);
    boolean darBajaFrutasPorProcedencia(String procedencia);
    boolean rebajar(double cantidad, int indexFruta);
    boolean rebajarNombreFruta (double cantidad, String nombreFruta);
    boolean subir(double cantidad, int indexFruta);
    boolean subirNombreFruta (double cantidad, String nombreFruta);
    double calcularInventarioTotal();
    boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta);
    boolean frutasDeMismaProcedencia(String nombre1, String nombre2);
    boolean reunirFrutasporProcedencia(String procedencia);
    boolean buscarFrutaPorNombre(String nombreFruta);
    boolean removeFrutasSinContenido();
    boolean eliminarFrutasCaducadas();

    boolean escribirFichero() throws FileNotFoundException;
    List<Fruta> leerFichero() throws FileNotFoundException;
    void eliminarTodo();
    List<Fruta> frutasConMenorNumeroVendido();
    List<Fruta> frutasConMayorNumeroVendido();
}
