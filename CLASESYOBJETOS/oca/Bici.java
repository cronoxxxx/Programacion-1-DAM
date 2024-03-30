package EJERCICIOS.CLASESYOBJETOS.oca;

public class Bici  extends  Casilla {


    public Bici(String nombre, int posicion) {
        super(nombre, posicion);
    }

    public Bici(int posicion) {
        super(posicion);

    }

    public Bici() {
    }

    @Override
    public String toString() {
        return "B";
    }
}
