package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.common.Colores;
import org.example.common.Comprobacion;
import org.example.common.DificultadException;
@Getter@Setter
public class SkiAlpino extends Pista {
    private String dificultad;

    public SkiAlpino(int id, String nombre, String provincia, double kmExtension, String dificultad) throws DificultadException {
        super(id, nombre, provincia, kmExtension);
        this.dificultad = dificultad;
        Comprobacion.dificultadOK(dificultad);
    }

    public SkiAlpino(String nombre, String provincia, double kmExtension,String dificultad) throws DificultadException {
        super(nombre, provincia, kmExtension);
        this.dificultad = dificultad;
        Comprobacion.dificultadOK(dificultad);
    }

    public SkiAlpino() {
        Colores[] c = Colores.values();
        this.dificultad = String.valueOf(c[(int)(Math.random() * c.length)]);
    }



    @Override
    public String toString() {
        return String.format("ID %d ||Nombre %s || Provincia %s || Km de extension %.2f || %s",id,nombre,provincia,kmExtension,dificultad);
    }

    public String toStringFile (){
        return id+";"+nombre+";"+provincia+";"+kmExtension+";"+dificultad;
    }
}
