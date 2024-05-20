package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Campeon;

import java.util.List;
@Getter@Setter
public class DaoDatabaseImpl implements DaoDatabase {
    Database database;

    public DaoDatabaseImpl(Database database) {
        this.database = database;
    }

    public DaoDatabaseImpl() {
        database = new Database();
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
}
