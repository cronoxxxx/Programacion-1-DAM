package org.example.Peliculas.InsertFiles.Files;

public class Actor {
    private int edad;
    private String nombreCompleto;

    private boolean esFamoso;

    public Actor() {
        this.edad = 20;
        this.nombreCompleto = "Adrian Saavedra";
        this.esFamoso = true;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean isEsFamoso() {
        return esFamoso;
    }

    public void setEsFamoso(boolean esFamoso) {
        this.esFamoso = esFamoso;
    }

    @Override
    public String toString() {
        return String.format("Nombre completo: %s,\nEdad: %d\n¿Es famoso? %b",nombreCompleto,edad,esFamoso);
    }
}
