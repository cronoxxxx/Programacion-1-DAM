package org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.servicio;

import org.example.Peliculas.InsertFiles.Files.com.softwarepeliculas.domain.Pelicula;

public interface IControlPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    void agregarPelicula (Pelicula pelicula);
    void buscarPelicula(Pelicula peliculaABuscar);
    void listarPeliculas();
    void iniciarControlDePeliculas();
}
