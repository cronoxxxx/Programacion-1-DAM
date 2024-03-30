package EJERCICIOS.CLASESYOBJETOS.oca;

public class Atajo extends  Casilla{
    public Atajo() {
    }

    public Atajo(String nombre, int posicion) {
        super(nombre, posicion);

    }



    public Atajo(int posicion) {
        super(posicion);
    }

    @Override
    public String toString() {
        return "A";
    }
}
