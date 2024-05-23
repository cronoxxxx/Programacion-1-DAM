package org.example.dao;

import lombok.Data;
import net.datafaker.Faker;
import org.example.common.DificultadException;
import org.example.domain.Pista;
import org.example.domain.Pueblo;
import org.example.domain.SkiFondo;

import java.io.Serializable;
import java.util.*;


@Data
public class Pistas implements Serializable {
    private List<Pista> pistas;



    public Pistas() {
        Faker f = new Faker();
        pistas = DaoFicheros.leerFichero();
        for (int i = 0; i < 4; i++) {
            pistas.add(new SkiFondo(List.of(new Pueblo(f.address().cityName()),new Pueblo(f.address().cityName()))));
        }
    }


    public List<Pista> mostrarInformacion (boolean ascendente){
        List<Pista> sorted = new ArrayList<>(pistas);
        if (ascendente){
            sorted.sort(Comparator.comparing(Pista::getProvincia).thenComparing(Pista::getNombre));
        } else {
            sorted.sort(Comparator.comparing(Pista::getProvincia).thenComparing(Pista::getNombre).reversed());
        }

        return sorted;
    }

    public boolean addPista (Pista pista){
        return pistas.add(pista);
    }

    public double devolverKmPorProvincia (String provincia){
        double suma = 0;
        for (int i = 0; i < pistas.size(); i++) {
            if (pistas.get(i).getProvincia().strip().equalsIgnoreCase(provincia)){
                suma+= pistas.get(i).getKmExtension();
            }
        }
        return suma > 0 ? suma : -1;
    }

    public boolean addPueblo (Pueblo pueblo, int idPista){
        Optional<SkiFondo> e = pistas.stream().filter(pista -> pista instanceof SkiFondo).map(pista -> (SkiFondo) pista).filter(pis -> pis.getId()==idPista).findFirst();
        if (e.isPresent()){
            e.filter(pista -> pista.addPueblo(pueblo));
            return true;
        }
        return false;
    }

    public boolean removePista (int id){
        return pistas.removeIf(pista -> pista.getId()==id);
    }

    public Map<String, List<Pista> > mapaProvinciaListaPistas(){
        Map<String, List<Pista> > mapa = new HashMap<>();
        for (Pista pista : pistas) {
            String prov = pista.getProvincia();
            if (!mapa.containsKey(prov)) {
                mapa.put(prov, new ArrayList<>());
            }
            mapa.get(prov).add(pista);
        }
        return mapa;
    }











}
