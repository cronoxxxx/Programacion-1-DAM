package EJERCICIOS.CLASESYOBJETOS.Inicial.E15;

public class Libro implements Comparable<Libro> {
    private String ISBN,titulo,autor;
    private int nPaginas;

    public Libro(String ISBN, String titulo, String autor, int nPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    @Override
    public String toString() {
        return String.format ("El libro %s con ISBN %s creado por el autor %s tiene %d páginas \n",titulo,ISBN,autor,nPaginas);
    }

    @Override
    public int compareTo(Libro o) {
        return Integer.compare(this.nPaginas,o.getnPaginas());
    }
}
