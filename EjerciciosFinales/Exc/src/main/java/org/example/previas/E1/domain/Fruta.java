package org.example.previas.E1.domain;

import org.example.previas.E1.common.*;

import java.io.Serializable;

/*
* En un almacén se guarda fruta para su posterior venta. Por cada cargamento se tiene la siguiente
información: nombre de la fruta, procedencia, número de kilos, precio coste por kilo y precio venta por
kilo. Codificar una clase para manejar esta información de forma que contenga las siguientes
operaciones:
• Constructor
• Método que devuelva la información de cada cargamento de fruta.
• Método “rebajar” que rebaja el precio de venta en una cantidad pasada
como parámetro, (el precio de venta nunca puede ser menor que el precio
de coste).
• Método “vender”: se le pasa el número de kilos a vender y si hay suficiente
cantidad, se decrementa el número de kilos y se devuelve el importe de la
venta, sino da error.
• Método que nos diga si dos cargamentos de fruta tienen la misma
procedencia.
• Llevar en todo momento el beneficio obtenido por el almacén.
Para probar dicha clase hacer un main que:
• Dé de alta 3 cargamentos y muestre su información.
• Diga si los dos primeros tienen la misma procedencia.
• Rebaje el precio del tercero.
• Realice ventas de los tres cargamentos.
• Muestre el beneficio obtenido por el almacén.
* caducidad - patatas
* */
public class Fruta implements Comparable<Fruta>, Serializable {
    private String nombre,procedencia;
    private int numeroKilos;
    private double precioCostePorKilo,precioVentaPorKilo;
public static int autonumerico = 1;



    public Fruta(String nombre, String procedencia, int numeroKilos, double precioCostePorKilo, double precioVentaPorKilo) throws precioVentaExcepcion, ProvinciaSpainException {
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.numeroKilos = numeroKilos;
        this.precioCostePorKilo = precioCostePorKilo;
        this.precioVentaPorKilo = precioVentaPorKilo;
        EnumComprobacionDirecta.precioVentaOK(precioVentaPorKilo,precioCostePorKilo);
        EnumComprobacionDirecta.provinciaOK(procedencia);
    }

    public Fruta (double precioCostePorKilo, double precioVentaPorKilo) throws precioVentaExcepcion {

        Frutas[] frutas= Frutas.values();
        Provincias[] provincias = Provincias.values();
        this.nombre = String.valueOf(frutas[(int) (Math.random() * frutas.length-1) +1]) + autonumerico;
        this.procedencia = provincias[(int) (Math.random() * provincias.length-1) + 1].toString();
        this.numeroKilos = (int) (Math.random() * 10000) + 1;
        this.precioCostePorKilo= precioCostePorKilo;
        this.precioVentaPorKilo=precioVentaPorKilo;
        autonumerico++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public int getNumeroKilos() {
        return numeroKilos;
    }

    public void setNumeroKilos(int numeroKilos) {
        this.numeroKilos = numeroKilos;
    }

    public double getPrecioCostePorKilo() {
        return precioCostePorKilo;
    }

    public void setPrecioCostePorKilo(double precioCostePorKilo) {
        this.precioCostePorKilo = precioCostePorKilo;
    }

    public double getPrecioVentaPorKilo() {
        return precioVentaPorKilo;
    }

    public void setPrecioVentaPorKilo(double precioVentaPorKilo) {
        this.precioVentaPorKilo = precioVentaPorKilo;
    }




    public String toString() {
        return String.format("Nombre de la fruta: %s\nProcedencia: %s\nNumero de kilos: %d\nPrecio Coste por kilo: %.2f\nPrecio de venta por kilo: %.2f",
                nombre, procedencia, numeroKilos, precioCostePorKilo, precioVentaPorKilo);
    }

    public String toStringFile(){
    return nombre+";"+procedencia+";"+numeroKilos+";"+precioCostePorKilo+";"+precioVentaPorKilo;
    }

    @Override
    public int compareTo(Fruta o) {
        return Double.compare(this.precioVentaPorKilo,o.precioVentaPorKilo);
    }
}
