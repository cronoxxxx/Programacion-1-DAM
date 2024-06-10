package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Pista;
import org.example.dao.Pistas;
import org.example.domain.Pueblo;

import java.util.List;
import java.util.Map;

@Getter@Setter
public class DaoPistasImpl implements DaoPistas {

    private Pistas pistas;

    public DaoPistasImpl() {
        pistas= new Pistas();
    }

    public List<Pista> getListaPistas(){
        return pistas.getPistas();
    }

    @Override
    public void setPistas(List<Pista> pistas) {
        this.pistas.setPistas(pistas);
    }



    public List<Pista> listadoOrdenadoProvinciaKm(boolean ascendente){
        return pistas.mostrarInformacion(ascendente);
    }

    public boolean addPista(Pista pista){
        return pistas.addPista(pista);
    }

    public double consulta(String provincia){
      return  pistas.devolverKmPorProvincia(provincia);
    }

    public boolean addPuebloListaPueblos(int id, Pueblo pueblo){
         return pistas.addPueblo(pueblo,id);

    }

    public boolean removePista(int id){
        return pistas.removePista(id);
    }

    public Map<String,List<Pista>> getPistasProvincia(){
        return pistas.mapaProvinciaListaPistas();
    }
}

