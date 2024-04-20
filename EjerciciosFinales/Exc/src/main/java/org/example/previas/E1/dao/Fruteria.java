package org.example.previas.E1.dao;

import org.example.previas.E1.common.FechaInvalidaException;
import org.example.previas.E1.domain.Cliente;
import org.example.previas.E1.domain.ClienteFisico;
import org.example.previas.E1.domain.ClienteOnline;
import org.example.previas.E1.domain.Fruta;

import java.io.FileNotFoundException;
import java.util.*;

public class Fruteria {
    List<Fruta> frutas;
    private double beneficios;


//crear un hashmap de clientes
    public Fruteria(List<Fruta> frutas) {
        this.frutas = frutas;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public Fruteria() {
        this.beneficios=0;
        try {
            frutas = DaoFicherosFruta.leerFichero();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        /*for (int i = 0; i < cantidadAlmacen; i++) {
            try {

                double precioCoste = (Math.random() * 40) + 1;
                double precioVenta = precioCoste + (Math.random() * 40) + 1;
                frutas.add(new Fruta(precioCoste, precioVenta));
            } catch (precioVentaExcepcion e) {
                System.out.println(e.getMessage());
                entrada.nextLine();
                i--;
            }
        }*/

    }



    /*public Fruteria (){
        this(50);
    }*/

    public List<Fruta> getFrutas() {
        return frutas;
    }
//propio de fruteria
    public List<Fruta> mostrarInformacion(boolean ascendente) {
        List<Fruta> elementosOrdenados = new ArrayList<>();
        elementosOrdenados = frutas;
        Collections.sort(elementosOrdenados);
        if (!ascendente) {
            Collections.reverse(elementosOrdenados);
        }
        return elementosOrdenados;
    }

    public void darAltaFruta(Fruta fruta) {
        frutas.add(fruta);
    }

    public boolean rebajar(double cantidad, int indexFruta) {
        if (indexFruta >= 0 && indexFruta < frutas.size()) {
            Fruta fruta = frutas.get(indexFruta);
            double nuevoPrecioVenta = fruta.getPrecioVentaPorKilo() - cantidad;
            if (nuevoPrecioVenta >= fruta.getPrecioCostePorKilo()) {
                fruta.setPrecioVentaPorKilo(nuevoPrecioVenta);
                System.out.println(fruta);
                return true;
            } else {
                System.out.println("La cantidad de rebaja es demasiado grande y haría que el precio de venta sea menor que el precio de coste.");
            }
        }
        return false;
    }


    //en posible otra clase



    public boolean frutasDeMismaProcedencia(String nombre1, String nombre2) {
        boolean valid = false;
        for (int i = 0; i < frutas.size() && !valid; i++) {
            if (frutas.get(i).getNombre().strip().equalsIgnoreCase(nombre1)) {
                for (int j = 0; j < frutas.size() && !valid; j++) {
                    if (frutas.get(j).getNombre().strip().equalsIgnoreCase(nombre2)) {
                        if (frutas.get(i).getProcedencia().equalsIgnoreCase(frutas.get(j).getProcedencia())) {
                            System.out.println("Se han encontrado dos frutas con la misma procedencia: " + frutas.get(i) + " y " + frutas.get(j));
                            valid = true;
                        }
                    }
                }
            }
        }

        return valid;
    }

    public boolean escribirFichero() {
        try {
            return DaoFicherosFruta.escribirFichero(mostrarInformacion(true));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }




}
