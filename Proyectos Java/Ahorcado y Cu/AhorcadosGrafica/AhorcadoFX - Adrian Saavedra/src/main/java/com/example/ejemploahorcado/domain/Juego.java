package com.example.ejemploahorcado.domain;

import com.example.ejemploahorcado.common.Constantes;
import com.example.ejemploahorcado.dao.Palabras;

import java.io.Serializable;
import java.util.Arrays;

import static com.example.ejemploahorcado.common.Constantes.EL_CARACTER_YA_HA_SIDO_INTRODUCIDO_AGREGUE_UNO_DISTINTO;

public class Juego implements Serializable {
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


    public Juego(Jugador jugador, int dificutad, String categoria, Palabra adivinar) throws CategoriaDificultadExcepcion {
        this.jugador = jugador;
        this.fallos = 0;
        //LLamo a clase de Palabras para implementar la palabra a adivinar, que me devuelve una palabra random
        this.aAdivinar = adivinar;
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

    public boolean comprobar(char letra) {
        boolean comprobada = false;
        for (int i = 0; i < palabraChar.length; i++) {
            if (palabraChar[i]==letra || palabraChar[i]==letra+32 || palabraChar[i]==letra-32){ //EN MAYUSCULA, MINISCULA O WHATEVER
                comprobada = true;

            }
        }
        if (!comprobada){setFallos();}
        return comprobada;//SI NINGUNA DE LAS LETRAS INGRSADAS ES CORRECTA, SE AGREGA UN FALLO
    }


    //SI LA PALABRA ES IGUAL A ALGUNOS DE LOS INTENTOS DEL JUGADOR, QUE CONTIENE LAS LETRAS QUE EL JUGADOR VA AÑADIENDO, SE IGUALA AL CHAR CREADO CON LA LONHGITUD DE LA PALABRA
    public String pintarpalabraChar() {
        StringBuilder sb = new StringBuilder();
        char[] obtenida = new char[aAdivinar.getIncognita().length()];

        for (int i = 0; i < palabraChar.length; i++) {
            switch (palabraChar[i]) {
                case ' '-> obtenida[i] = ' ';
                case '-' -> obtenida[i] = '-';
                case '(', ')'->
                    obtenida[i] = palabraChar[i];
                default->{
                    boolean encontrado = false;
                    for (char intento : jugador.getIntentos()) {
                        if (palabraChar[i] == intento || palabraChar[i] == intento + 32 || palabraChar[i] == intento - 32) {
                            obtenida[i] = palabraChar[i];
                            sb.append(intento).append(" ");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        obtenida[i] = 95; // código ASCII de '_'
                        sb.append(" _ ");
                    }
                }
            }
        }

        System.out.println(Constantes.ESTA_ES_LA_PALABRA_QUE_TIENES_QUE_ADIVINAR + Arrays.toString(obtenida).replace(",", " ").replace("[", "").replace("]", ""));
        return sb.toString();
    }

    public String pintarFallidas (){ //getter de fallidos
        StringBuilder sb = new StringBuilder();
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
                    //System.out.println(jugador.getIntentos().get(i)+" ");
                    sb.append(jugador.getIntentos().get(i)).append(" ");
                }
            }
        }
        return sb.toString();
    }
    //EL PRINCIPAL:
    public String jugada (char letra){ //evalua toda la jugada
        String texto= null;
        if (letra > 64 && letra < 123){
            if (jugador.anyadirLetra(letra)){//SI SE AÑADE LA PALABRA POR PRIMERA VEZ, SE EVALUA
                if(!comprobar(letra)){
                    texto = Constantes.ERRORES;
                }
                /*pintarTablero();
                pintarpalabraChar();
                pintarFallidas();*/
            } else {
                texto = Constantes.EL_CARACTER_YA_HA_SIDO_INTRODUCIDO_AGREGUE_UNO_DISTINTO;
            }
        } else {
            texto = Constantes.CARACTER_INVALIDO;
        }
        return texto;
    }
    public int fin() {
        int fin = 0;
        boolean palabraCompleta = true;

        char[] obtenido = new char[aAdivinar.getIncognita().length()];

        for (int i = 0; i < palabraChar.length; i++) {
            switch (palabraChar[i]){
                case ' '->obtenido[i] = ' ';
                case '-'->obtenido[i]='-';
                case '(',')'->obtenido[i]=palabraChar[i];
                default -> {
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
        }

        if (palabraCompleta) {
            fin = 2;//cuando ganas
        } else if (fallos == 7) {

            fin = 1;
        }

        return fin;
    }



}
