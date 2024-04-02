package service;

import common.*;
import dao.*;
import domain.*;

import java.io.IOException;
import java.util.List;

public class GestionPalabras implements IGestionPalabras {

    private final DaoPalabras daoPalabras;


    public GestionPalabras()  {
        this.daoPalabras = new DaoPalabrasImplementacion();
    }

    public GestionPalabras(DaoPalabras daoPalabras) {
        this.daoPalabras = daoPalabras;
    }

    @Override
    public boolean isEmptyPalabrasList() {
        return daoPalabras.isEmptyPalabrasList();
    }

    @Override
    public List<Palabra> getListaPalabras() {
        return daoPalabras.getListaDePalabras();
    }

    @Override
    public boolean insertarPalabra(Palabra palabra) {
        return daoPalabras.insertarPalabra(palabra);
    }

    @Override
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException {
        return daoPalabras.insertarPalabra(id,level,incognita,categoria);
    }


    @Override
    public List<Palabra> listar(String categoria) {
        return daoPalabras.getPalabrasCategoria(categoria);
    }

    @Override
    public List<Palabra> listar(int nivel, String categoria) {
        return daoPalabras.getPalabrasNivelCategoria(nivel,categoria);
    }

    @Override
    public List<Palabra> listar(int nivel) {
        return daoPalabras.getPalabrasNivel(nivel);
    }

    @Override
    public List<Palabra> listarPalabras(boolean ascendente) {
        return daoPalabras.getPalabrasOrdenadas(ascendente);
    }

    @Override
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException {
        return daoPalabras.modificarCategoria(id,categoria);
    }

    @Override
    public boolean modificarPalabra(int id, String incognita) {
        return daoPalabras.modificarPalabra(id,incognita);


    }

      @Override
    public List<Palabra> getListaPalabrasCategoria(String categoria) {
        return daoPalabras.getPalabrasCategoria(categoria);
    }

    @Override
    public boolean eliminarPalabra(Palabra Palabra) {
        return daoPalabras.eliminarPalabra(Palabra);
    }

    @Override
    public boolean eliminarPalabra(int id) {
        return daoPalabras.eliminarPalabra(id);
    }
    @Override
    public void idOK(int id) throws IDException {
        daoPalabras.idOK(id);
    }

//PARA DESPUES
    @Override
    public void crearFicheros() throws IOException {}

    @Override
    public boolean cargarFichero() throws IOException {
        return false;
    }

    @Override
    public boolean escribirFichero() {
        return false;
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }


}