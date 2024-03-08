package EJERCICIOS.CLASESYOBJETOS.Basicos.E6;
/*
* Crear la clase Chalet. Atributos privados String calle, short numParcela, double precio, int superficie, boolean
conPiscina. Crear constructores por defecto como se desee. Crear getters y setters, que cumplan estas
validaciones: numParcela ha de estar entre 1-10, precio no puede ser negativo, superficie no puede ser
negativo ni mayor de 2000. Probar en una clase con un método main.*/
public class Chalet {
    private String calle;
    private short numParcela;
    private double precio;
    private int superficie;
    private final boolean conPiscina;

    public Chalet(String calle, short numParcela, double precio, int superficie) {
        this.calle = calle;
        this.numParcela = numParcela;
        this.precio = precio;
        this.superficie = superficie;
        this.conPiscina = true;
    }
    public Chalet(String calle, short numParcela, int superficie, double precio) {
        this.calle = calle;
        this.numParcela = numParcela;
        this.precio = precio;
        this.superficie = superficie;
        this.conPiscina = false;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public short getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(short numParcela) {

            this.numParcela=numParcela;

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

                this.precio = precio;

    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {


            this.superficie=superficie;

    }

    public boolean isConPiscina() {
        return conPiscina;
    }
}
