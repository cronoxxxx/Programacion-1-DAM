package org.example.dao;

import org.example.domain.CentrosOcio;
import org.example.domain.ParqueAtracciones;

import java.util.List;
import java.util.Map;

public interface DaoDatabase {
    List<CentrosOcio> mostrarInformacion(boolean ascendente);

    boolean addCentro(CentrosOcio centro);

    List<CentrosOcio> consultaCentrosPorProvincia(String provincia);

    boolean addServicioZoo(int id, String servicio);

    List<ParqueAtracciones> devolverParquesOrdenados(int edad, boolean festivo);

    boolean eliminarCentrosPorAnyo(int anyo);

    Map<String, Map<String, Long>> obtenerCentrosPorProvinciaConNumeroDeCentros();
}
