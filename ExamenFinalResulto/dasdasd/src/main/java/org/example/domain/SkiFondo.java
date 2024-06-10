package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.example.common.DificultadException;

import java.util.*;
import java.util.stream.Collectors;
@Getter@Setter
public class SkiFondo extends Pista {
    Set<Pueblo> pueblos;

    public SkiFondo(int id, String nombre, String provincia, double kmExtension, Set<Pueblo> pueblosAdd) {
        super(id, nombre, provincia, kmExtension);
        this.pueblos = new HashSet<>(pueblosAdd);
    }

    public SkiFondo(String nombre, String provincia, double kmExtension, List<String> pueblosAdd) {
        super(nombre, provincia, kmExtension);
        pueblos = new HashSet<>();
        for (String s : pueblosAdd) {
            pueblos.add(new Pueblo(s));
        }



    }



    public SkiFondo(List<Pueblo> pueblosAdd) {
        this.pueblos = new HashSet<>(pueblosAdd);

    }

    public SkiFondo(int id, String nombre, String provincia, double kmEntension) {
        this.pueblos=new HashSet<>();
    }



    public boolean addPueblo (Pueblo pueblo)  {
        if (pueblos.contains(pueblo)){
            return false;
        }
        return pueblos.add(pueblo);
    }

    @Override
    public String toString() {
        return String.format("ID %d ||Nombre %s || Provincia %s || Km de extension %.2f || %s",id,nombre,provincia,kmExtension,pueblos.toString());
    }

    @Override
    public String toStringFile() {
        return super.toStringFile() +";"+pueblos.toString().replace("[","").replace("]","").replace(", ",",");
    }

}
