package org.example.Peliculas.InsertFiles.Files;

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



    @Override
    public String toString() {
        return String.format("Nombre: %s\nAño: %d\nEs Estreno: %b\nEs Famosa: %b\nActor: %s",
                nombre, anyo, isEstreno, isFamosa, actorPrincipal);
    }
}
