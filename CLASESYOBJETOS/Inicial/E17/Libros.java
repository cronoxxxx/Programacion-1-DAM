package EJERCICIOS.CLASESYOBJETOS.Inicial.E17;

public class Libros {
    private String titulo,autor;
    private int nPaginas, calificacion;

    public void calificacionOK(int c) throws CalificacionException {
        if (c<0 || c>10){
            throw new CalificacionException();
        }
    }

    public Libros(String titulo, String autor, int nPaginas, int calificacion) throws CalificacionException {
        calificacionOK(calificacion);
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.calificacion = calificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {

        return String.format("Titulo %s\nAutor%s\nCalificacion %d\nNumero de paginas %d",titulo,autor,calificacion,nPaginas);
    }
}
