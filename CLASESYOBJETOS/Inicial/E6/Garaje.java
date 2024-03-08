package EJERCICIOS.CLASESYOBJETOS.Inicial.E6;

public class Garaje {
    private PlazaGaraje[]plazas;
    private int numPlazas = 0;
    public Garaje() {
        plazas= new PlazaGaraje[100];
    }
    public void construyePlazas(){
        if (numPlazas < plazas.length) {
            numPlazas++;
            System.out.println("Plaza creada: Plaza " + numPlazas);
            plazas[numPlazas - 1] = new PlazaGaraje(/* Aquí deberías proporcionar datos necesarios */);
            System.out.println("Total de plazas: " + numPlazas);
        } else {
            System.out.println("El garaje está lleno, no se pueden crear más plazas.");
        }
    }
    public void alquilarPlaza (Coche asignado, int numeroDePlaza){
        boolean siExiste = false;
        for (int i = 0; i < plazas.length && !siExiste; i++) {
            if (plazas[i]==null){
                if (i==numeroDePlaza){
                    plazas[i]=new PlazaGaraje(asignado,0.0);
                    siExiste=true;
                }
            }
        }
        if (siExiste){
            System.out.println("Se agregó con exito");
        } else {
            System.out.println("Esa plaza ya esta llena, disculpa las molestias");
        }
    }

    public void asignarImporte (double importeAlquiler,int numPlaza){
        boolean siExiste = false;
        for (int i = 0; i < plazas.length && !siExiste; i++) {
            if (plazas[i]!=null){
                if (i==numPlaza){
                    plazas[i].setCoste(importeAlquiler);
                    System.out.println("Datos del coche: "+plazas[i].getCoche());
                    System.out.println("Coste: "+plazas[i].getCoste());
                    siExiste=true;
                }
            }
        }
    }

    public double calcularIngresosGarage (){
        double costeTotal = 0;
        for (int i = 0; i < plazas.length; i++) {
            if(plazas[i]!=null){
                costeTotal+=plazas[i].getCoste();
            }
        }
        return costeTotal;
    }
    public boolean bajaPlaza(int numPlaza){
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i]!=null){
                if (i==numPlaza){
                    plazas[i]=null;
                    return true;
                }
            }
        }
        return false;
    }
    public double plazaMasBarata (){
        double plazaMasBarata = plazas[0].getCoste(); // Inicializar con el primer costo

        for (int i = 1; i < plazas.length; i++) {
            if (plazas[i] != null) {
                double costoActual = plazas[i].getCoste();
                plazaMasBarata = Math.min(plazaMasBarata, costoActual);
                return plazaMasBarata;
            }
        }
        return plazaMasBarata;
    }
}
