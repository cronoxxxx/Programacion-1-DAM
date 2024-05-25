package domain;

public class CategoriaDificultadExcepcion extends Exception {
    public CategoriaDificultadExcepcion() {
        super("No se han encontrado ningun elemento con esa dificultad y categoria ");
    }

    public CategoriaDificultadExcepcion(String categoria, int dificultad) {
        super("No existe ningun elemento con la categoria "+categoria+" y la dificultad "+dificultad);
    }
}
