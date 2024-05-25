package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {
    private String nombre;
    private List<Character>intentos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.intentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Character> getIntentos() {
        return intentos;
    }

    public void setIntentos(List<Character> intentos) {
        this.intentos = intentos;
    }

    public boolean anyadirLetra(char letra) {
        boolean agregada = false;
        if (!intentos.contains(letra)) {
            intentos.add(letra);
            agregada = true;
        }
        return agregada;
    }
}











































/*public boolean anyadirLetra (char letra){
        boolean existente = false,agregada=false;
        for (int i = 0; i < intentos.size(); i++) {
            if (intentos.get(i)==letra){
                existente=true; //COMPRUEBA SI LA LETRA EXISTE YA EN INTENTOS, OSEA, SI YA HA SIDO INGRESADA
            }
        }
        if (!existente){
            intentos.add(letra); //SINO, SE VA AGREGANDO LO QUE VA PONIENDO AL USUARIO
            agregada=true;
        }
        return agregada;

    }*/