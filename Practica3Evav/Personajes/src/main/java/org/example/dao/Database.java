package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Asesino;
import org.example.domain.Campeon;
import org.example.domain.Mago;

import java.util.*;

@Getter
@Setter
public class Database {
    private List<Campeon> campeones;

    public Database() {
        campeones = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            if (i%2==0){
                campeones.add(new Mago());
            } else{
                campeones.add(new Asesino());
            }
        }
    }

    public List<Campeon> mostrarInformacion (boolean ascendente){
        List <Campeon> sorted = new ArrayList<>(campeones);
        if (ascendente){
            sorted.sort (Comparator.comparing(Campeon::getNombre));
        } else {
            sorted.sort (Comparator.comparing(Campeon::getNombre).reversed());
        }

        return sorted;
    }



    public boolean addCampeon (Campeon campeon){
        return campeones.add(campeon);
    }

    public List<Campeon> dentroDeRangoAtaque (int init, int bound){
        List <Campeon> rankeds = new ArrayList<>();
        for (int i = 0; i < campeones.size() ; i++) {
            if (campeones.get(i).getAtaque()>init && campeones.get(i).getAtaque()<bound){
                rankeds.add(campeones.get(i));
            }
        }
        return rankeds;
    }

    public boolean actualizarBurst(int id){
        if (id<0 || id>campeones.size()){
            return false;
        }
        for (int i = 0; i < campeones.size(); i++) {
            if (campeones.get(i) instanceof Asesino){
                if (campeones.get(i).getId()==id){
                    if (((Asesino) campeones.get(i)).isBurst()){
                        ((Asesino) campeones.get(i)).setBurst(false);
                    } else {
                        ((Asesino) campeones.get(i)).setBurst(true);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean eliminarUsuarioID(int id){
       return campeones.removeIf(campeon -> campeon.getId()==id);
    }


    public Map<String, List<Campeon>> getHabilidadesMap() {
        Map<String, List<Campeon>> habilidadesMap = new HashMap<>();

        for (int i = 0; i < campeones.size(); i++) {
            Campeon campeon = campeones.get(i);
            for (int j = 0; j < campeon.getHabilidades().size(); j++) {
                String habilidad = campeon.getHabilidades().get(j);
                if (!habilidadesMap.containsKey(habilidad)) {
                    habilidadesMap.put(habilidad, new ArrayList<>());
                }
                habilidadesMap.get(habilidad).add(campeon);
            }
        }

        return habilidadesMap;
    }









}
