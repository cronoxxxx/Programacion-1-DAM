package EJERCICIOS.CLASESYOBJETOS.Inicial.E5;

public class Garaje {
    private PlazaGaraje []plazas;

    public Garaje() {
        plazas=new PlazaGaraje[10];
    }
    public void construyePlazas(){
        for (int i = 0; i < plazas.length; i++) {
            plazas[i]=null;
        }
    }
    public void alquilarPlaza(Coche uncoche, int numPlaza, double coste) {
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = new PlazaGaraje(uncoche,coste);

            }
        }

    }

}
