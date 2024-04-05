package domain;

import common.*;
import dao.*;

import java.util.Arrays;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Palabra aAdivinar; //o el String directamente
    private Jugador jugador;
    private int fallos;
    private char[] palabraChar;

    public Juego(Palabra aAdivinar, Jugador jugador) {
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        this.fallos = 0;
    }
    //crear un elemento de obtener elemento en la clase palabras (ya creado y listo para su implementacion)


    //metodo para usar el try catch de una forma amena
    public void categoriaDificultadOK(String categoria, int dificultad) throws CategoriaDificultadExcepcion {
        boolean esta = false;
        Palabras palabras = new Palabras();
        if (palabras.getPalabraDificultadCategoria(dificultad, categoria) != null) {
            esta = true;
        }
        if (!esta) {
            throw new CategoriaDificultadExcepcion(categoria, dificultad);
        }

    }

    public Juego(Jugador jugador, int dificutad, String categoria) throws CategoriaDificultadExcepcion {
        categoriaDificultadOK(categoria, dificutad);
        this.jugador = jugador;
        this.fallos = 0;
        //LLamo a clase de Palabras para implementar la palabra a adivinar, que me devuelve una palabra random
        Palabras palabras = new Palabras();
        this.aAdivinar = palabras.getPalabraDificultadCategoria(dificutad, categoria);
        //paso la palabra a caracteres, uso el metodo toCharArray para ello, las ire implementando poco a poco
        palabraChar = aAdivinar.getIncognita().toCharArray();
    }



    public Palabra getaAdivinar() {
        return aAdivinar;
    }

    public void setaAdivinar(Palabra aAdivinar) {
        this.aAdivinar = aAdivinar;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos() {
        this.fallos = fallos + 1; //LO MISMO QUE LOS TURNOS EN AJEDREZ
    }

    //por si las moscas
    public void moreFallos() {
        this.fallos = fallos + 1;
    }

    public char[] getPalabraChar() {
        return palabraChar;
    }

    public void setpalabraChar(char[] palabraChar) {
        this.palabraChar = palabraChar;
    }

    public void pintarTablero() {
        switch (fallos) {
            case 0 -> System.out.println(Constantes.FALLOCERO);
            case 1 -> System.out.println(Constantes.FALLO1);
            case 2 -> System.out.println(Constantes.FALLO2);
            case 3 -> System.out.println(Constantes.FALLO3);
            case 4 -> System.out.println(Constantes.FALLO4);
            case 5 -> System.out.println(Constantes.FALLO5);
            case 6 -> System.out.println(Constantes.FALLO6);
            case 7 -> System.out.println(Constantes.FALLO7);
        }
    }
    //implementacion de codigo ASCII para detectar fallos

    public void comprobar(char letra) {
        boolean comprobada = false;
        for (int i = 0; i < palabraChar.length; i++) {
            if (palabraChar[i]==letra || palabraChar[i]==letra+32 || palabraChar[i]==letra-32){ //EN MAYUSCULA, MINISCULA O WHATEVER
                comprobada = true;
                //System.out.println("¡LA HAS PILLADO!");
                System.out.println(Constantes.LA_HAS_PILLADO);
            }
        }
        if (!comprobada){setFallos();} //SI NINGUNA DE LAS LETRAS INGRSADAS ES CORRECTA, SE AGREGA UN FALLO
    }


    //SI LA PALABRA ES IGUAL A ALGUNOS DE LOS INTENTOS DEL JUGADOR, QUE CONTIENE LAS LETRAS QUE EL JUGADOR VA AÑADIENDO, SE IGUALA AL CHAR CREADO CON LA LONHGITUD DE LA PALABRA
    public void pintarpalabraChar() {
        char[] obtenida = new char[aAdivinar.getIncognita().length()];

        for (int i = 0; i < palabraChar.length; i++) {
            if (palabraChar[i] == ' ') { //Si la palabra es un caracter vacio, la obtenida introduce este valor
                obtenida[i] = ' ';
            } else if (palabraChar[i] == '-') {
                obtenida[i] = '-';
            } else {
                for (int j = 0; j < jugador.getIntentos().size(); j++) { //evalua las letras que va añadiendo el jugador
                    if (palabraChar[i]==jugador.getIntentos().get(j) ||palabraChar[i]==jugador.getIntentos().get(j)+32 || palabraChar[i]==jugador.getIntentos().get(j)-32 ){
                        obtenida[i]=palabraChar[i];
                    }
                }
                if (obtenida [i]==0 ){ //null
                    obtenida[i]= 95; //codigo ascii de _____
                }

            }
        }

        System.out.println(Constantes.ESTA_ES_LA_PALABRA_QUE_TIENES_QUE_ADIVINAR + Arrays.toString(obtenida).replace(","," ").replace("[","").replace("]",""));
    }


    public void pintarFallidas (){ //getter de fallidos
        if (fallos!=0){
            System.out.println(Constantes.ERRORES);
            for (int i = 0; i < jugador.getIntentos().size(); i++) {
                boolean esta = false;
                for (int j = 0; j < palabraChar.length; j++) {
                    if (jugador.getIntentos().get(i)==palabraChar[j] || jugador.getIntentos().get(i)==palabraChar[j]+32 || jugador.getIntentos().get(i)==palabraChar[j]-32){
                        esta=true;
                    }
                }
                if (!esta){
                    System.out.println(jugador.getIntentos().get(i)+" ");
                }
            }
        }
    }
    //EL PRINCIPAL:
    public void jugada (char letra){ //evalua toda la jugada
        if (letra > 64 && letra < 123){
            if (jugador.anyadirLetra(letra)){//SI SE AÑADE LA PALABRA POR PRIMERA VEZ, SE EVALUA
                comprobar(letra);
                pintarTablero();
                pintarpalabraChar();
                pintarFallidas();
            } else {
                System.out.println(Constantes.EL_CARACTER_YA_HA_SIDO_INTRODUCIDO_AGREGUE_UNO_DISTINTO);
            }
        } else {
            System.out.println(Constantes.CARACTER_INVALIDO);
        }
    }
    public int fin() {
        int fin = 0;
        boolean palabraCompleta = true;

        char[] obtenido = new char[aAdivinar.getIncognita().length()];

        for (int i = 0; i < palabraChar.length; i++) {
            if (palabraChar[i] == ' ') {
                obtenido[i] = ' ';
            }else if (palabraChar[i] == '-') {
                obtenido[i] = '-';
            }
            else {
                boolean encontrada = false;
                for (char intento : jugador.getIntentos()) {
                    if (palabraChar[i] == intento || palabraChar[i] == intento + 32 || palabraChar[i] == intento - 32) {
                        obtenido[i] = palabraChar[i];
                        encontrada = true;
                    }
                }
                if (!encontrada) {
                    obtenido[i] = '_';
                    palabraCompleta = false;
                }
            }
        }

        if (palabraCompleta) {
            fin = 2;
        } else if (fallos == 7) {

            fin = 1;
        }

        return fin;
    }



}
