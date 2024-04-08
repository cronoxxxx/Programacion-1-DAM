package exdrafts.com.software.peliculas.service;

public interface IControlPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    void agregarPelicula (String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String peliculaBuscar);
    void iniciarControlDePeliculas();
}
