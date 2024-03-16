package dao;

import common.CategoriaException;
import domain.Palabra;

import java.io.IOException;
import java.util.List;

public interface DaoPalabras {
    //personal 1
    public List<Palabra> getListaDePalabras();
    public boolean isEmptyPalabrasList() ;
    public boolean insertarPalabra(Palabra Palabra) ;
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Palabra> getPalabrasCategoria(String categoria);
    public List<Palabra> getPalabrasNivelCategoria(int nivel, String categoria);
    public List<Palabra> getPalabrasNivel (int nivel);
    public List<Palabra> getPalabrasOrdenadas(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria);
    public boolean modificarPalabra(int id, String incognita);
    public void eliminarPalabra(Palabra Palabra) ;
    public void eliminarPalabra(int id) ;
    //personal 2
    public void idOK(int id )throws IDException;
    }
