package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.common.Comparators;
import org.example.domain.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Database implements Serializable {
    private List<CentrosOcio> centrosOcio;

    public Database() {
        List<Zoologico> zoologicos = new ArrayList<>();
        List<ParqueAtracciones> parques = new ArrayList<>();
        try {
            zoologicos = DaoFicheros.leerFichero();
            //parques = DaoFicheros.leerBinarioDatabase().getParques();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        centrosOcio = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            parques.add(new ParqueAtracciones());
            zoologicos.add(new Zoologico());

        }
        centrosOcio.addAll(parques);
        centrosOcio.addAll(zoologicos);
    }

    public List<Zoologico> getZoologicos() {
        return centrosOcio.stream().filter(c -> c instanceof Zoologico).map(c -> (Zoologico) c).toList();
    }
/*
    public List<ParqueAtracciones> getParques() {
        return centrosOcio.stream().filter(c -> c instanceof ParqueAtracciones).map(c -> (ParqueAtracciones) c).toList();
    }*/

    public List<CentrosOcio> mostrarInformacion(boolean ascendente) {
        List<CentrosOcio> sortedList = new ArrayList<>(centrosOcio);
        if (ascendente) {
            sortedList.sort(new Comparators.provinciaComparator().thenComparing(CentrosOcio::getFechaAlta));
        } else {
            sortedList.sort(new Comparators.provinciaComparator().thenComparing(CentrosOcio::getFechaAlta).reversed());
        }
        return sortedList;
    }

    public boolean addCentro(CentrosOcio centro) {
        int maxId = centrosOcio.stream().filter(c -> c instanceof Zoologico).map(c -> (Zoologico) c).mapToInt(Zoologico::getId).max().orElse(0);
        centro.setId(maxId + 1);
        return centrosOcio.add(centro);
    }

    public List<CentrosOcio> consultaCentrosPorProvincia(String provincia) {
        return centrosOcio.stream().filter(c -> c.getProvincia().equals(provincia)).toList();
    }

    public boolean addServicioZoo(int id, String servicio) {
        if (id < 0 || id >= centrosOcio.size()) {
            return false;
        }
        centrosOcio.stream().filter(c -> c instanceof Zoologico).map(c -> (Zoologico) c).filter(c -> c.getId() == id).
                findFirst().ifPresent(c -> c.addServicio(servicio));
        return true;
    }

    public List<ParqueAtracciones> devolverParquesOrdenados(int edad, boolean festivo) {
        List<ParqueAtracciones> parques = new ArrayList<>(centrosOcio.stream().filter(c -> c instanceof ParqueAtracciones)
                .map(c -> (ParqueAtracciones) c).filter(parque -> parque.precioEntradaReal(edad, festivo) != -1).toList());
        parques.sort(Comparator.comparing(ParqueAtracciones::getProvincia).thenComparing(ParqueAtracciones::getFechaAlta));
        return parques;
    }

    public boolean eliminarCentrosPorAnyo(int anyo) {
        return centrosOcio.removeIf(c -> c.getFechaAlta().getYear() < anyo);
    }

    public Map<String, Map<String, Long>> obtenerCentrosPorProvinciaConNumeroDeCentros() {
        return centrosOcio.stream().collect(Collectors.groupingBy(CentrosOcio::getProvincia, Collectors.groupingBy(c -> {
                    if (c instanceof Zoologico) {
                        return "Zoo";
                    } else if (c instanceof ParqueAtracciones) {
                        return "Parque";
                    } else {
                        return "Otro";
                    }
                }, Collectors.counting())));
    }


}
