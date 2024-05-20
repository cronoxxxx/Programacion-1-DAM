package org.example.dao;

import org.example.domain.CentrosOcio;
import org.example.domain.ParqueAtracciones;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DaoDatabaseImpl implements DaoDatabase {

    private Database database;

    public DaoDatabaseImpl(Database database) {
        this.database = database;
    }
    public DaoDatabaseImpl() {
        try {
            database = DaoFicheros.leerBinarioDatabase();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public List<CentrosOcio> mostrarInformacion(boolean ascendente) {
        return database.mostrarInformacion(ascendente);
    }

    @Override
    public boolean addCentro(CentrosOcio centro) {
        return database.addCentro(centro);
    }

    @Override
    public List<CentrosOcio> consultaCentrosPorProvincia(String provincia) {
        return database.consultaCentrosPorProvincia(provincia);
    }

    @Override
    public boolean addServicioZoo(int id, String servicio) {
        return database.addServicioZoo(id, servicio);
    }

    @Override
    public List<ParqueAtracciones> devolverParquesOrdenados(int edad, boolean festivo) {
        return database.devolverParquesOrdenados(edad, festivo);
    }

    @Override
    public boolean eliminarCentrosPorAnyo(int anyo) {
        return database.eliminarCentrosPorAnyo(anyo);
    }

    @Override
    public Map<String, Map<String, Long>> obtenerCentrosPorProvinciaConNumeroDeCentros() {
        return database.obtenerCentrosPorProvinciaConNumeroDeCentros();
    }
}
