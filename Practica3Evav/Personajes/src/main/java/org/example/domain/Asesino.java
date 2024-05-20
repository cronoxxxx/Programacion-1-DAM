package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.common.AddHabilidadesException;

import java.util.List;
@Getter@Setter
public class Asesino extends Campeon {
    private boolean burst;

    public Asesino(int numeroSkins, String nombre, double ataque, double altura, List<String> habilidades, boolean burst) throws AddHabilidadesException {
        super(numeroSkins, nombre, ataque, altura, habilidades);
        this.burst = burst;
    }

    public Asesino() {
        this.burst = (int)(Math.random() * 2) == 1;
    }

    @Override
    public double ataqueReal() {
        double ataqueReal = 0;
        for (int i = 0; i < habilidades.size() ; i++) {
            ataqueReal +=ataque + (ataque*0.15);
        }
        return ataqueReal;
    }

    @Override
    public String toString() {
        return String.format("Nº Skins %d || Nombre %s || ataque %.2f ||altura %.2f || Habilidades %s || Burst %b",numeroSkins,nombre,ataque,altura,habilidades.toString(),burst );
    }


}
