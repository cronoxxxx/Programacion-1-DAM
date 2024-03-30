package EJERCICIOS.CLASESYOBJETOS.Inicial.E62;

public class Reloj {
    private int hora, minuto, segundo;

    public Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Reloj(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public Reloj(int hora) {
        this.hora = hora;
    }

    public boolean adelantarReloj(int cantidadSegundos) {
        this.segundo += cantidadSegundos;

        while (this.segundo >= 60) {
            this.segundo -= 60;
            this.minuto++;
        }

        while (this.minuto >= 60) {
            this.minuto -= 60;
            this.hora++;
        }

        while (this.hora >= 24) {
            this.hora -= 24;
        }

        return true;
    }

    public boolean retrocederReloj(int cantidadSegundos) { //3600
        //ejemplo : 10hrs 15min 0seg
        this.segundo -= cantidadSegundos; //0- 3600

        while (this.segundo < 0) {
            this.segundo += 60; // va a dar 60 vueltas hasta que sea positivo o dero
            this.minuto--; //retrocede 15 en la primera, 45 en la segunda despues de rehabilitarse
        }

        while (this.minuto < 0) {
            this.minuto += 60; // llega a 60 una vez, y de ahi retrocede 45 veces para llegar a 15 (solo fue menor de 0 una vez)
            this.hora--; // solo retrocede una hora
        }

        while (this.hora < 0) {
            this.hora += 24;
        }

        return true;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void imprimirHora (){
        System.out.println(getHora()+":"+getMinuto()+":"+getSegundo());
    }
}
