package org.example.common;

public class Comprobacion {
    public static boolean dificultadOK (String dificultad) throws DificultadException {
        boolean valid = false;
        Colores[] c = Colores.values();
        for (int i = 0; i < c.length && !valid ; i++) {
            if (dificultad.strip().equalsIgnoreCase(c[i].toString())){
                valid = true;
            }
        }

        if (!valid){
            throw new DificultadException("No se puede añadir una dificultad distinta a azul, verde y rojo");
        }
        return valid;
    }
}
