package org.example.service;

import org.example.common.DificultadException;
import org.example.dao.DaoFicheros;
import org.example.dao.DaoPistas;
import org.example.dao.DaoPistasImpl;
import org.example.domain.Pista;
import org.example.domain.Pueblo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IServiceInterface implements ServiceInterface {
    private DaoPistas daoPistas;

    public IServiceInterface() {
        this.daoPistas = new DaoPistasImpl();
    }

    public List<Pista> getListaPistas(){
       return daoPistas.getListaPistas();
   }
    public List<Pista> listadoOrdenadoProvinciaKm(boolean ascendente){
        return daoPistas.listadoOrdenadoProvinciaKm(ascendente);
    }
    public boolean addPista(Pista pista) {
        return daoPistas.addPista(pista);
    }
    public double consulta(String provincia){
        return daoPistas.consulta(provincia);
    }
    public boolean addPuebloListaPueblos(int id, Pueblo pueblo){
        return daoPistas.addPuebloListaPueblos(id,pueblo);
    }
    public boolean removePista(int id){
        return daoPistas.removePista(id);
    }
    public Map<String,List<Pista>> getPistasProvincia(){
        return daoPistas.getPistasProvincia();
    }

    public void crearFicheros() throws IOException{
        DaoFicheros.crearFicheros();
    }
    public boolean cargarFichero() throws IOException{
        if (DaoFicheros.leerFichero()!=null){
            DaoFicheros.leerFichero();
            return true;
        }
        return false;
    }
    public boolean escribirFichero(){
        try {
            return DaoFicheros.escribirFichero(daoPistas.listadoOrdenadoProvinciaKm(true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean escribirFicheroBinario(){
        return DaoFicheros.escribirBinario(daoPistas.getPistas());
    }
    public boolean cargarFicheroBinario(){
        if (DaoFicheros.leerBinario()!=null){
            DaoFicheros.leerBinario();
            return true;
        }
        return false;
    }
}
