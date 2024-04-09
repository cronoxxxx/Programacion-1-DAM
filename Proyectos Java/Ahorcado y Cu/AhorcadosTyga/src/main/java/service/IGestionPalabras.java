package service;

import common.CategoriaException;
import dao.IDException;
import domain.Juego;
import domain.Palabra;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

public interface IGestionPalabras {
    public boolean isEmptyPalabrasList();
    public List<Palabra> getListaPalabras();
    public boolean insertarPalabra(Palabra Palabra);

    /**
     *
     * @param id
     * @param level
     * @param incognita
     * @param categoria si la categoria no es válida se lanzará una excepción y no será insertado el elememto
     * @return
     * @throws CategoriaException
     */
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Palabra> listar(String categoria);
    public List<Palabra> listar(int nivel, String categoria);
    public List<Palabra> listar (int nivel);
    public List<Palabra> listarPalabras(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException;
    public boolean modificarPalabra(int id, String incognita);

    public List<Palabra> getListaPalabrasCategoria(String categoria);
    public boolean eliminarPalabra(Palabra Palabra);
    public boolean eliminarPalabra (int id);
    public void crearFicheros()throws IOException;
    public boolean cargarFichero() throws IOException;
    public boolean escribirFichero() throws IOException;
    public boolean escribirFicheroBinario(Juego j);
    public Juego cargarFicheroBinario() throws EOFException;
    void leerFichero() throws IOException;
    void idOK(int id) throws IDException;

}
