package org.example.Peliculas.Files;

public class Pelicula {
    private String nombre;
    private int anyo;
    private boolean isEstreno;
    private boolean isFamosa;
    private Actor actorPrincipal;

    public Pelicula(String _nombre, int _anyo, boolean _isEstreno, boolean _isFamosa, Actor actorPrincipal) {
        nombre = _nombre;
        anyo = _anyo;
        isEstreno = _isEstreno;
        isFamosa = _isFamosa;
        this.actorPrincipal = actorPrincipal;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Actor getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(Actor actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public boolean isEstreno() {
        return isEstreno;
    }

    public void setEstreno(boolean estreno) {
        isEstreno = estreno;
    }

    public boolean isFamosa() {
        return isFamosa;
    }

    public void setFamosa(boolean famosa) {
        isFamosa = famosa;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nAño: %d\nEs Estreno: %b\nEs Famosa: %b\nActor: %s",
                nombre, anyo, isEstreno, isFamosa, actorPrincipal);
    }
}
