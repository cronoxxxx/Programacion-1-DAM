package EJERCICIOS.CLASESYOBJETOS.Inicial.E3;

public class Satelite {
    private double paralelo;
    private double meridiano;

    public Satelite(double paralelo, double meridiano) {
        this.paralelo = paralelo;
        this.meridiano = meridiano;
    }

    public double getParalelo() {
        return paralelo;
    }

    public double getMeridiano() {
        return meridiano;
    }


    public boolean cambiarPosicionParalelo(double incrementoP){
        boolean menorDiez=true;
        double aux=paralelo+incrementoP;
        if (aux<=-100 || aux>=10000){
            menorDiez=false;
        } else {
            paralelo=aux;
        }
            return menorDiez;
    }
    public boolean cambiarPosicionMeridiano (double incrementoM){
        boolean menorDiez=true;
        double aux = meridiano+incrementoM;
        if (aux<=-100 || aux>=10000){
            menorDiez=false;
        } else {
            meridiano=aux;
        }
        return menorDiez;
    }

    @Override
    public String toString() {
        return "Paralelo: "+paralelo+"\nMeridiano"+meridiano;
    }
}
