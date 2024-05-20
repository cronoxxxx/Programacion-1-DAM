package org.example.service;

import org.example.dao.DaoDatabaseImpl;
import org.example.dao.DaoFicheros;
import org.example.dao.Database;
import org.example.domain.CentrosOcio;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoologico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GestionDatabase implements IGestionDatabase {
    private DaoDatabaseImpl database;

    public GestionDatabase(DaoDatabaseImpl database) {
        this.database = database;
    }
    public GestionDatabase() {
        this.database = new DaoDatabaseImpl();
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

    @Override
    public boolean escribirZoologicos() {
        try {
            return DaoFicheros.escribirFichero(database.getDatabase().getZoologicos());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean escribirBinario() {
        try {
            return DaoFicheros.escribirBinarioDatabase(database.getDatabase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
