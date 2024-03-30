package EJERCICIOS.CLASESYOBJETOS.oca;

public class Jugada {
    private boolean turno;

    public Jugada(boolean turno) {
        this.turno = turno;
    }

    public Jugada() {
        this.turno = false;
    }


    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }



    /*public void cambioTurno(String jugador1, String jugador2) {
        if (this.turno) {
            System.out.println("Turno de " + jugador2);
            this.turno = false; // Cambia el turno al segundo jugador
        } else {
            System.out.println("Turno de " + jugador1);
            this.turno = true; // Cambia el turno al primer jugador
        }
    }*/


}
