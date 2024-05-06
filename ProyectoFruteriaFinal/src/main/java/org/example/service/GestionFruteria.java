package org.example.service;

import lombok.Getter;
import org.example.dao.DaoFicherosFruta;
import org.example.dao.DaoFruteriaImplementacion;
import org.example.domain.Fruta;

import java.io.FileNotFoundException;
import java.util.List;
@Getter
public class GestionFruteria implements IGestionFruteria {
    private final DaoFruteriaImplementacion daoFruteriaImplementacion;

    public GestionFruteria() {
        this.daoFruteriaImplementacion = new DaoFruteriaImplementacion();
    }
    public GestionFruteria(DaoFruteriaImplementacion daoFruteriaImplementacion) {
        this.daoFruteriaImplementacion = daoFruteriaImplementacion;
    }

    @Override
    public List<Fruta> getFrutas() {
        return daoFruteriaImplementacion.getFrutas();
    }

    @Override
    public boolean isEmptyFrutas() {
        return daoFruteriaImplementacion.isEmptyFrutas();
    }

    @Override
    public List<Fruta> mostrarInformacion(boolean ascendente) {
        return daoFruteriaImplementacion.mostrarInformacion(ascendente);
    }

    @Override
    public boolean darAltaFruta(Fruta fruta) {
        return daoFruteriaImplementacion.darAltaFruta(fruta);
    }

    @Override
    public boolean darBajaFrutaPorNombre(String nombreFruta) {
        return daoFruteriaImplementacion.darBajaFrutaPorNombre(nombreFruta);
    }

    @Override
    public boolean darBajaFrutasPorProcedencia(String procedencia) {
        return daoFruteriaImplementacion.darBajaFrutasPorProcedencia(procedencia);
    }

    @Override
    public boolean rebajar(double cantidad, int indexFruta) {
        return daoFruteriaImplementacion.rebajar(cantidad, indexFruta);
    }

    @Override
    public boolean rebajarNombreFruta(double cantidad, String nombreFruta) {
        return daoFruteriaImplementacion.rebajarNombreFruta(cantidad, nombreFruta);
    }

    @Override
    public boolean subir(double cantidad, int indexFruta) {
        return daoFruteriaImplementacion.subir(cantidad, indexFruta);
    }

    @Override
    public boolean subirNombreFruta(double cantidad, String nombreFruta) {
        return daoFruteriaImplementacion.subirNombreFruta(cantidad, nombreFruta);
    }

    @Override
    public double calcularInventarioTotal() {
        return daoFruteriaImplementacion.calcularInventarioTotal();
    }

    @Override
    public boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta) {
        return daoFruteriaImplementacion.actualizarPrecioVenta(nombreFruta, nuevoPrecioVenta);
    }

    @Override
    public boolean frutasDeMismaProcedencia(String nombre1, String nombre2) {
        return daoFruteriaImplementacion.frutasDeMismaProcedencia(nombre1, nombre2);
    }

    @Override
    public boolean reunirFrutasporProcedencia(String procedencia) {
        return daoFruteriaImplementacion.reunirFrutasporProcedencia(procedencia);
    }

    @Override
    public boolean buscarFrutaPorNombre(String nombreFruta) {
        return daoFruteriaImplementacion.buscarFrutaPorNombre(nombreFruta);
    }

    @Override
    public boolean removeFrutasSinContenido() {
        return daoFruteriaImplementacion.removeFrutasSinContenido();
    }

    @Override
    public boolean eliminarFrutasCaducadas() {
        return daoFruteriaImplementacion.eliminarFrutasCaducadas();
    }

    @Override
    public boolean escribirFichero()  {
        try {
            return DaoFicherosFruta.escribirFichero(mostrarInformacion(true));
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public List<Fruta> leerFichero() throws FileNotFoundException {
        return DaoFicherosFruta.leerFichero();
    }

    @Override
    public void eliminarTodo() {
        daoFruteriaImplementacion.eliminarTodo();
    }

    @Override
    public boolean updateFruta(Fruta fruta) {
        return daoFruteriaImplementacion.updateFruta(fruta);
    }

    @Override
    public boolean removeFruta(Fruta fruta) {
        return daoFruteriaImplementacion.removeFruta(fruta);
    }

    @Override
    public List<Fruta> frutasConMenorNumeroVendido() {
        return daoFruteriaImplementacion.frutasConMenorNumeroVendido();
    }

    @Override
    public List<Fruta> frutasConMayorNumeroVendido() {
        return daoFruteriaImplementacion.frutasConMayorNumeroVendido();
    }
}
