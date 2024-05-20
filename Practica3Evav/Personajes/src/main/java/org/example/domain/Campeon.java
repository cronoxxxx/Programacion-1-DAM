package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.example.common.AddHabilidadesException;
import org.example.common.Comprobacion;
import org.example.common.Habilidades;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public abstract class Campeon  {
    protected int id,numeroSkins;
    protected String nombre;
    protected double ataque,altura;
    protected static int autonumerico = 0;
    protected List <String> habilidades;

    public Campeon(int numeroSkins, String nombre, double ataque, double altura, List<String>habilidades) throws AddHabilidadesException {
        autonumerico++;
        this.id = autonumerico;
        this.numeroSkins = numeroSkins;
        this.nombre = nombre;
        this.ataque = ataque;
        this.altura = altura;
        this.habilidades = new ArrayList<>();
        this.habilidades.addAll(habilidades);
        Comprobacion.habilidadesOK(habilidades);

    }

    public Campeon() {
        Faker faker = new Faker();
        autonumerico++;
        this.id = autonumerico;
        this.numeroSkins = (int)(Math.random()*10) + 1;
        this.nombre = faker.name().firstName();
        this.ataque = (Math.random() * 12) + 2;
        this.altura = (Math.random() * 3) + 1;
        this.habilidades = new ArrayList<>();
        Habilidades [] h = Habilidades.values();
        for (int i = 0; i < (int)(Math.random() * h.length) + 1 ; i++) {
            habilidades.add(String.valueOf(h[i]));
        }
    }

    public abstract double ataqueReal ();
}
