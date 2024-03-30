package EJERCICIOS.CLASESYOBJETOS.oca;

public abstract class Casilla {

    protected String nombre;
    protected int posicion;

    public Casilla(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public Casilla(int posicion) {
        this.posicion = posicion;
    }





    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Casilla() {
    }


}
