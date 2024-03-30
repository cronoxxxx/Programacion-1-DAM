package EJERCICIOS.CLASESYOBJETOS.oca;

public class Mercadillo extends  Casilla{
    public Mercadillo(String nombre, int posicion) {
        super(nombre, posicion);
    }

    public Mercadillo(int posicion) {
        super(posicion);
    }


    public Mercadillo() {
    }

    @Override
    public String toString() {
        return "M";
    }
}
