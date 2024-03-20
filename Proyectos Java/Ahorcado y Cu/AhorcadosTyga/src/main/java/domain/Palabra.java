package domain;


import common.CategoriaException;
import common.Comprobacion;
import dao.Palabras;

import java.util.Objects;
import java.util.StringJoiner;

public class Palabra implements Comparable<Palabra> {
    private int id;
    private int level;
    private String incognita;
    private String categoria;

    public static int autonumerico = 1;

    /**
     *
     * param id identicador único de cada elemento, el String incognita puede tener espacios, mayúsculas, mínúsculas que no lo hagan único
     * param level indica la dificultad que le asignamos a la incognita a adivinar por el tamaño de caracteres por ejemplo
     * param incognita palabra a adivinar
     * param categoria String que debe se un elemento de Categoria, si no lo es se lanzará CategoriaEx y así no se creará el objeto
     * throws CategoriaException arroja esta excepción si la categoría no es una de las establecidas
     */
    public Palabra(int id, int level, String incognita, String categoria) throws CategoriaException {
        this.id = id;
        this.level = level;
        this.incognita = incognita;
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }
    /*public Palabra(int level, String incognita, String categoria) throws CategoriaException {
        this.id = Palabras.getAutonumerico();
        Palabras.setAutonumerico(Palabras.getAutonumerico()+1);
        this.level = level;
        this.incognita = incognita;

        this.categoria = categoria;
    }*/

    public Palabra(String incognita, String categoria)throws CategoriaException  {
        this.id=autonumerico;
        autonumerico++;
        //asignar nivel 1 para caracteres mayores de 7, 0 para los de menor
        this.level = asignarNivel(incognita);
        Comprobacion.categoriaOk(categoria);
        this.incognita = incognita.trim();
        this.categoria = categoria;
    }

    public int asignarNivel(String incognita){
        int nivel = 0;
        if (incognita.length()>=6){
            nivel =1;
        }
        return nivel;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws CategoriaException {
        Comprobacion.categoriaOk(categoria);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNivel: %d\nIncognita %s\nCategoria: %s",id,level,incognita,categoria);
    }
    public String toStringFile() {
        return id + ";" + level +
                ";" + incognita +
                ";" + categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIncognita() {
        return incognita.trim();
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public static int getAutonumerico() {
        return autonumerico;
    }

    public static void setAutonumerico(int autonumerico) {
        Palabra.autonumerico = autonumerico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palabra palabra = (Palabra) o;
        return Objects.equals(incognita, palabra.incognita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, incognita, categoria);
    }

    @Override
    public int compareTo(Palabra o) {
        return Integer.compare(this.id,o.getId());
    }
}
