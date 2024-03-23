package EJERCICIOS.CLASESYOBJETOS.Inicial.amplios.oca;

public class DrogasNo extends Casilla {
    public DrogasNo(String nombre, int posicion) {
        super(nombre, posicion);
    }

    public DrogasNo(int posicion) {
        super(posicion);
        nombre="D";
    }

    public DrogasNo() {
    }

    @Override
    public String toString() {
        return "D";
    }
}
