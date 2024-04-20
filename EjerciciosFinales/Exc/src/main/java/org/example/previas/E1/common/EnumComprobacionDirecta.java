package org.example.previas.E1.common;

import java.time.LocalDate;

public class EnumComprobacionDirecta {

    public static void provinciaOK (String provincia) throws ProvinciaSpainException {
        String reset = provincia.strip().replace(" ","");
        Provincias [] aux = Provincias.values();
        boolean valido = false;
        for (int i = 0;i< aux.length && !valido;i++){
            if (aux[i].toString().equalsIgnoreCase(reset)){
                valido = true;
            }
        }

        if (!valido){
            throw new ProvinciaSpainException();
        }
    }

    public static void precioVentaOK(double precioVentaPorKilo, double precioCostePorKilo) throws precioVentaExcepcion {
        if (precioVentaPorKilo<precioCostePorKilo){
            throw new precioVentaExcepcion();
        }
    }

    public static void fechaOK(LocalDate fechaEntregaPedido) throws FechaInvalidaException {
        if (fechaEntregaPedido.isBefore(LocalDate.now())){
            throw new FechaInvalidaException ();
        }
    }


}
