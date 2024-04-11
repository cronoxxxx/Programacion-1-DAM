package com.example.ejemploahorcado.dao;

import com.example.ejemploahorcado.common.CategoriaException;
import com.example.ejemploahorcado.domain.CategoriaDificultadExcepcion;
import com.example.ejemploahorcado.domain.Palabra;

import java.util.List;

public interface DaoPalabras {
    //personal 1
    public Palabras getLista();
    public List<Palabra> getListaDePalabras();
    public boolean isEmptyPalabrasList() ;
    public boolean insertarPalabra(Palabra Palabra) ;
    public boolean insertarPalabra(int id, int level, String incognita, String categoria) throws CategoriaException;
    public List<Palabra> getPalabrasCategoria(String categoria);
    public List<Palabra> getPalabrasNivelCategoria(int nivel, String categoria);
    public List<Palabra> getPalabrasNivel (int nivel);
    public List<Palabra> getPalabrasOrdenadas(boolean ascendente);
    public boolean modificarCategoria(int id, String categoria) throws CategoriaException;
    public boolean modificarPalabra(int id, String incognita);
    public boolean eliminarPalabra(Palabra Palabra) ;
    public boolean eliminarPalabra(int id) ;
    //personal 2
    public void idOK(int id )throws IDException;
    public void categoriaDificultadOK(String categoria, int dificultad) throws CategoriaDificultadExcepcion;
}
