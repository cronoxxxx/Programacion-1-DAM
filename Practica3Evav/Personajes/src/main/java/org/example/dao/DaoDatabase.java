package org.example.dao;

import org.example.domain.Campeon;

import java.util.List;

public interface DaoDatabase {

    List<Campeon> mostrarInformacion (boolean ascendente);
    boolean addCampeon (Campeon campeon);
    List<Campeon> dentroDeRangoAtaque (int init, int bound);
    boolean actualizarBurst(int id);

    boolean eliminarUsuarioID(int id);
}
