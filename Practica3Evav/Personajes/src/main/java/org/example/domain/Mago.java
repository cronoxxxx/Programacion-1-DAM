package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.common.AddHabilidadesException;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Mago extends Campeon {
    private boolean stunt;


    public Mago(int numeroSkins, String nombre, double ataque, double altura, List<String> habilidades, boolean stunt) throws AddHabilidadesException {
        super(numeroSkins, nombre, ataque, altura, habilidades);
        this.stunt = stunt;
    }

    public Mago() {
        this.stunt = (int)(Math.random() * 2) == 1;
    }

    @Override
    public double ataqueReal() {
        double ataqueReal = 0;
        for (int i = 0; i < habilidades.size() ; i++) {
            ataqueReal +=ataque + (ataque*0.05);
        }
        return ataqueReal;
    }

    @Override
    public String toString() {
        return String.format("Nº Skins %d || Nombre %s || ataque %.2f ||altura %.2f || Habilidades %s || Stunt %b",numeroSkins,nombre,ataque,altura,habilidades.toString(),stunt );
    }

    public String toStringFile(){
        return numeroSkins+";"+nombre+";"+ataque+";"+altura+";"+habilidades.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","))+";"+stunt;
    }


}

