package org.example.service;

import org.example.common.DificultadException;
import org.example.domain.Pista;
import org.example.domain.Pueblo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ServiceInterface {
    List<Pista> getListaPistas();
    List<Pista> listadoOrdenadoProvinciaKm(boolean ascendente);
    boolean addPista(Pista pista) throws DificultadException;
    double consulta(String provincia);
    boolean addPuebloListaPueblos(int id, Pueblo pueblo);
    boolean removePista(int id);
    Map<String,List<Pista>> getPistasProvincia();

    void crearFicheros() throws IOException;
    boolean cargarFichero() throws IOException;
    boolean escribirFichero();
    boolean escribirFicheroBinario();
    boolean cargarFicheroBinario();
}