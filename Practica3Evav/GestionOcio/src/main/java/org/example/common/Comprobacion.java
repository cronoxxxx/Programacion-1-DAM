package org.example.common;

import java.util.regex.Pattern;

public class Comprobacion {

    public static void precioEntradaParqueOK (double precioEntrada) throws precioEntradaException {
        if (precioEntrada < 0) {
            throw new precioEntradaException("El precio de entrada no puede ser negativo");
        } else if (precioEntrada <15 || precioEntrada>25){
            throw new precioEntradaException("El precio de entrada no puede ser menor que 15 ni mayor que 25");
        }

    }
    public static void precioEntradaZooOK (double precioEntrada) throws precioEntradaException {
        if (precioEntrada < 0) {
            throw new precioEntradaException("El precio de entrada no puede ser negativo");
        } else if (precioEntrada <10 || precioEntrada>20){
            throw new precioEntradaException("El precio de entrada no puede ser menor que 10 ni mayor que 20");
        }

    }
    public static void valoracionOK (int valoracion) throws valoracionException {
        if (valoracion < 0 || valoracion > 5) {
            throw new valoracionException("La valoracion no puede ser negativa ni mayor que 5");
    }
    }

    public static void correoOK (String correo) throws correoException {
        Pattern pattern = Pattern.compile("^\\w+@\\w+\\.\\w+$");
        if (!pattern.matcher(correo).matches()) {
            throw new correoException("El correo no es valido");
        }

    }
}

