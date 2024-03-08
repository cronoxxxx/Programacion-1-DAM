package EJERCICIOS.CLASESYOBJETOS.Basicos.E4;

public class Vivienda {
    public String calle;
    public int numero,superficie;
    public double precio;
    public boolean conGarage;

    public Vivienda(String calle, int numero, int superficie, double precio) {
        this.calle = calle;
        this.numero = numero;
        this.superficie = superficie;
        this.precio = precio;
        this.conGarage = true;
        System.out.println("Tiene garaje");
    }

    public Vivienda(String calle, int numero, double precio, int superficie) {
        this.calle = calle;
        this.numero = numero;
        this.precio = precio;
        this.conGarage = false;
        this.superficie=superficie;
        System.out.println("No tiene garaje");
    }
    public Vivienda(){
        this.calle = null;
        this.numero = 0;
        this.precio = 0;
        this.conGarage = false;
        this.superficie=0;
        System.out.println("VUELVE PRONTO");
    }
}
