package EJERCICIOS.CLASESYOBJETOS.oca;

public class Tablero {
    private Casilla[] casillas;
    private int posicionJugadorX;
    private int posicionJugadorY;

    public Tablero() {
        casillas = new Casilla[95];
        posicionJugadorX = 0;
        posicionJugadorY = 0;
        casillas[93] = new DrogasNo();
        for (int i = 0; i < casillas.length; i++) {
            if (i == 10 || i == 40 || i == 60 || i == 66) {
                casillas[i] = new Bici();
            } else if (i == 14 || i == 30 || i == 46 || i == 62 || i == 78) {
                casillas[i] = new Mercadillo();
            } else if (i == 16 || i == 32 || i == 48 || i == 64 || i == 80) {
                casillas[i] = new Atajo();
            } else {
                casillas[i] = new CorreCoree();
            }
        }
    }

    public int getPosicionJugadorX() {
        return posicionJugadorX;
    }

    public int getPosicionJugadorY() {
        return posicionJugadorY;
    }

    public void mostrarTablero() {
        int a = 16;
        for (int i = 0; i < casillas.length; i++) {
            if (i == posicionJugadorX) {
                System.out.print("X ");
            } else if (i == posicionJugadorY) {
                System.out.print("Y ");
            } else if (i == 0) {
                System.out.print("S ");
            } else if (i == 94) {
                System.out.print("F ");
            } else if (casillas[i] != null) {
                System.out.print(casillas[i] + " ");
            }
            if ((i + 1) % a == 0) {
                System.out.println();
                a += 16;
            }
        }
    }

    public boolean realizarMovimiento(Jugada jugada) {
        int dado = (int) (Math.random() * 20) + 1;

        if (jugada.isTurno()) {
            int nuevaPosicionX = posicionJugadorX + dado;
            if (posicionJugadorX < casillas.length) {
                if (nuevaPosicionX < casillas.length) {
                    switch (casillas[nuevaPosicionX].getClass().getSimpleName()) {
                        case "Bici":
                            int nuevaPosicionBici = nuevaPosicionX * 2;
                            if (nuevaPosicionBici < casillas.length) {
                                posicionJugadorX = nuevaPosicionBici;
                                System.out.println("No hay quien te pare");
                            } else {
                                int rebote = nuevaPosicionBici - casillas.length; // Calcular rebote
                                posicionJugadorX = casillas.length - rebote; // Actualizar posición con rebote
                                System.out.println("Rebote en Bici");
                            }
                            break;
                        case "Mercadillo":
                            posicionJugadorX -= 10;
                            System.out.println("Pero donde vas?");
                            break;
                        case "Atajo":
                            posicionJugadorX += dado + 16; // Corregido
                            System.out.println("De atajo en atajo porque eres el mas majo");
                            break;
                        case "DrogasNo":
                            posicionJugadorX = 0;
                            System.out.println("Drogas no");
                            break;
                        default:
                            posicionJugadorX += dado; // Corregido
                            System.out.println("Corre corre que te pillan");
                    }
                } else {
                    int rebote = nuevaPosicionX- casillas.length; // Calcular rebote
                    posicionJugadorX = casillas.length - rebote;
                }
            } else {
                System.out.println("El jugador X ha llegado al final del juego");
                return true;
            }
        } else {
            int nuevaPosicionY = posicionJugadorY + dado;
            if (posicionJugadorY < casillas.length) {
                if (nuevaPosicionY < casillas.length) {
                    switch (casillas[nuevaPosicionY].getClass().getSimpleName()) {
                        case "Bici":
                            int nuevaPosicionBici = nuevaPosicionY * 2;
                            if (nuevaPosicionBici < casillas.length) {
                                posicionJugadorY = nuevaPosicionBici;
                                System.out.println("No hay quien te pare");
                            } else {
                                int rebote = nuevaPosicionBici - casillas.length; // Calcular rebote
                                posicionJugadorY = casillas.length - rebote; // Actualizar posición con rebote
                                System.out.println("Rebote en Bici");
                            }
                            break;
                        case "Mercadillo":
                            posicionJugadorY -= 10;
                            System.out.println("Pero donde vas?");
                            break;
                        case "Atajo":
                            posicionJugadorY += dado + 16; // Corregido
                            System.out.println("De atajo en atajo porque eres el mas majo");
                            break;
                        case "DrogasNo":
                            posicionJugadorY = 0;
                            System.out.println("Drogas no");
                            break;
                        default:
                            posicionJugadorY += dado; // Corregido
                            System.out.println("Corre corre que te pillan");
                    }
                } else {
                    int rebote = nuevaPosicionY- casillas.length; // Calcular rebote
                    posicionJugadorY = casillas.length - rebote;
                }
            } else {
                System.out.println("El jugador Y ha llegado al final del juego");
                return true;
            }
        }
        return  false;
    }


        //Un metodo copia del otro que sera un bucle, y sera 1 si una de las piezas llega a 95, sino va a ser 0;



    /*public void realizarMovimiento(Jugada jugada) {
        int dado = (int) (Math.random() * 20);

        if (jugada.isTurno()) {
            int nuevaPosicionX = posicionJugadorX + dado;
            if (nuevaPosicionX < casillas.length) {
                posicionJugadorX = nuevaPosicionX;
            } else {
                System.out.println("El jugador X ha llegado al final del tablero");
            }
        } else {
            int nuevaPosicionY = posicionJugadorY + dado;
            if (nuevaPosicionY < casillas.length) {
                posicionJugadorY = nuevaPosicionY;
            } else {
                System.out.println("El jugador Y ha llegado al final del tablero.");
            }
        }

    }*/
    }












