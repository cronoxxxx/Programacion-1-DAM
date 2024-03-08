package EJERCICIOS.CLASESYOBJETOS.Inicial.E6;

public class PlazaGaraje {
    private Coche coche;
    private double coste;

    public PlazaGaraje(Coche coche, double coste) {
        this.coche = coche;
        this.coste = coste;
    }

    public PlazaGaraje() {
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
