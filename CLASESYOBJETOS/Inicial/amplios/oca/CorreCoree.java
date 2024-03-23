package EJERCICIOS.CLASESYOBJETOS.Inicial.amplios.oca;

import java.util.StringJoiner;

public class CorreCoree extends Casilla{
    public CorreCoree(String nombre, int posicion) {
        super(nombre, posicion);
    }

    public CorreCoree(int posicion) {
        super(posicion);

    }



    public CorreCoree() {
    }

    @Override
    public String toString() {
        return "- ";
    }
}
