package domain;

import common.*;
import dao.*;

import java.util.Arrays;

public class Juego {
    //pensar en los atributos que definen el estado del juego en ese instante para que que si lo paran se pueda recuperar
    private Palabra aAdivinar; //o el String directamente
    private Jugador jugador;
    private int fallos;
    private char[] adivinadas;

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
        adivinadas = aAdivinar.getIncognita().toCharArray();
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

    public char[] getAdivinadas() {
        return adivinadas;
    }

    public void setAdivinadas(char[] adivinadas) {
        this.adivinadas = adivinadas;
    }

    public void pintarTablero() {
        switch (fallos) {
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
        for (int i = 0; i < adivinadas.length; i++) {
            if (adivinadas[i]==letra || adivinadas[i]==letra+32 || adivinadas[i]==letra-32){ //EN MAYUSCULA, MINISCULA O WHATEVER
                comprobada = true;
                //System.out.println("¡LA HAS PILLADO!");
                System.out.println(Constantes.LA_HAS_PILLADO);
            }
        }
        if (!comprobada){setFallos();} //SI NINGUNA DE LAS LETRAS INGRSADAS ES CORRECTA, SE AGREGA UN FALLO
    }


    //SI LA PALABRA ES IGUAL A ALGUNOS DE LOS INTENTOS DEL JUGADOR, QUE CONTIENE LAS LETRAS QUE EL JUGADOR VA AÑADIENDO, SE IGUALA AL CHAR CREADO CON LA LONHGITUD DE LA PALABRA
    public void pintarAdivinadas (){
        char [] obtenida = new char [aAdivinar.getIncognita().length()]; //longitud de la palabra
        for (int i = 0; i < adivinadas.length; i++) { //evalua si alguna de las letras ingresadas por el usuario es igual a alguna letra de la palabra original
            for (int j = 0; j < jugador.getIntentos().size(); j++) {
                if (adivinadas[i]==jugador.getIntentos().get(j) ||adivinadas[i]==jugador.getIntentos().get(j)+32 || adivinadas[i]==jugador.getIntentos().get(j)-32 ){
                    obtenida[i]=adivinadas[i];
                }
            }
            if (obtenida [i]==0 ){ //null
                obtenida[i]=  95; //codigo ascii de _____
            }
        }
        System.out.println(Constantes.ESTA_ES_LA_PALABRA_QUE_TIENES_QUE_ADIVINAR + Arrays.toString(obtenida)); //solo pone los caracteres adivinados



    }

    public void pintarFallidas (){ //getter de fallidos
        if (getFallos()!=0){
            System.out.println(Constantes.ERRORES);
            for (int i = 0; i < jugador.getIntentos().size(); i++) {
                boolean esta = false;
                for (int j = 0; j < adivinadas.length; j++) {
                    if (jugador.getIntentos().get(i)==adivinadas[j] || jugador.getIntentos().get(i)==adivinadas[j]+32 || jugador.getIntentos().get(i)==adivinadas[j]-32){
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
                pintarAdivinadas();
                pintarFallidas();
            } else {
                System.out.println(Constantes.EL_CARACTER_YA_HA_SIDO_INTRODUCIDO_AGREGUE_UNO_DISTINTO);
            }
        } else {
            System.out.println(Constantes.CARACTER_INVALIDO);
        }
    }
    public int fin (){
        int fin = 0;
        if (fallos==7){
            fin=1;
        } else {
            char []obtenido = new char[aAdivinar.getIncognita().length()];
            for (int i = 0; i < adivinadas.length; i++) {
                boolean esta = false;
                for (int j = 0; j < jugador.getIntentos().size(); j++) {
                    if (adivinadas[i]==jugador.getIntentos().get(j) || adivinadas[i]==jugador.getIntentos().get(j)+32 || adivinadas[i]==jugador.getIntentos().get(j)-32){
                        esta=true;
                    }
                }
            }
            fin = 2;
            for (int i = 0; i < obtenido.length; i++) {
                if (obtenido[i]==0){
                    fin = 0;
                }
            }
        }
        return fin;
    }


}
