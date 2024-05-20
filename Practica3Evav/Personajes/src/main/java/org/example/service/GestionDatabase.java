package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.dao.DaoDatabaseImpl;
import org.example.dao.DaoFicheros;
import org.example.domain.Campeon;

import java.util.List;

@Getter@Setter
public class GestionDatabase implements IGestionDatabase {
    private DaoDatabaseImpl database;
    public GestionDatabase() {
        database = new DaoDatabaseImpl();
    }

    @Override
    public List<Campeon> mostrarInformacion(boolean ascendente) {
        return database.mostrarInformacion(ascendente);
    }

    @Override
    public boolean addCampeon(Campeon campeon) {
        return database.addCampeon(campeon);
    }

    @Override
    public List<Campeon> dentroDeRangoAtaque(int init, int bound) {
        return database.dentroDeRangoAtaque(init,bound);
    }

    @Override
    public boolean actualizarBurst(int id) {
        return database.actualizarBurst(id);
    }

    @Override
    public boolean eliminarUsuarioID(int id) {
        return database.eliminarUsuarioID(id);
    }

    @Override
    public boolean escribirFicheroTexto() {
        return DaoFicheros.escribirFichero(database.mostrarInformacion(true));
    }

    @Override
    public boolean escribirFicheroBinario() {
        return DaoFicheros.escribirBinario(database.getDatabase());
    }
}
