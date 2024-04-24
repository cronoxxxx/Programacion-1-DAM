package org.example.previas.E1.domain;

import org.example.previas.E1.common.precioVentaExcepcion;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private final ArrayList<Fruta> frutas;

    public Database() throws precioVentaExcepcion {
        frutas= new ArrayList<>();
        for (int i=0; i<20;i++){
            frutas.add(new Fruta(Math.random()*30,(Math.random() * 30) + 31));
        }
    }

    public Database (ArrayList<Fruta> frutas){
        this.frutas = frutas;
    }

    public List<Fruta> getListafrutas() {
        return frutas;
    }


    public void setListafrutas(List<Fruta> frutas) {
        this.frutas.clear();
        this.frutas.addAll(frutas);
    }
}
