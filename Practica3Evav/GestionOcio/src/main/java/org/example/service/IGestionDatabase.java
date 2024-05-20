package org.example.service;

import org.example.dao.Database;
import org.example.domain.CentrosOcio;
import org.example.domain.ParqueAtracciones;
import org.example.domain.Zoologico;

import java.util.List;
import java.util.Map;

public interface IGestionDatabase {

    List<CentrosOcio> mostrarInformacion(boolean ascendente);

    boolean addCentro(CentrosOcio centro);

    List<CentrosOcio> consultaCentrosPorProvincia(String provincia);

    boolean addServicioZoo(int id, String servicio);

    List<ParqueAtracciones> devolverParquesOrdenados(int edad, boolean festivo);

    boolean eliminarCentrosPorAnyo(int anyo);

    Map<String, Map<String, Long>> obtenerCentrosPorProvinciaConNumeroDeCentros();

    boolean escribirZoologicos();
    boolean escribirBinario ();
}
