package org.example.previas.E1.common;

import java.time.LocalDate;

public class EnumComprobacionDirecta {

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
    public static void provinciaOK(String provinciaAgregar) throws AgregarProvinciasException {
        Provincias[] aux = Provincias.values();
        boolean valid = false;
        for (int i = 0; i < aux.length && !valid ; i++) {
            if (aux[i].toString().equalsIgnoreCase(provinciaAgregar.replace(" ",""))){
                valid=true;
            }
        }

        if (!valid){
            throw new AgregarProvinciasException();
        }
    }


}
