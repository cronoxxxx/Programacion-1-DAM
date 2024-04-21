package org.example.previas.E1.dao;

import org.example.previas.E1.common.*;
import org.example.previas.E1.domain.*;

import java.io.*;
import java.util.*;

public class Fruteria implements Serializable {
    private List<Fruta> frutas;

    //crear un hashmap de clientes
    public Fruteria(List<Fruta> frutas) {
        this.frutas = frutas;
    }


    public Fruteria() {

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

    public boolean isEmptyFrutas() {
        return frutas.isEmpty();
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

    /*public void darAltaFruta(Fruta fruta) {
        // Verificar si el nombre de la fruta ya existe en la lista
        boolean nombreRepetido = false;
        for (Fruta f : frutas) {
            if (f.getNombre().equalsIgnoreCase(fruta.getNombre())) {
                nombreRepetido = true;
                break;
            }
        }

        // Si el nombre no está repetido, agregar la fruta a la lista
        if (!nombreRepetido) {
            frutas.add(fruta);
            System.out.println("Fruta agregada con éxito.");
        } else {
            System.out.println("Ya existe una fruta con el mismo nombre en la frutería.");
        }
    }*/

    public boolean darAltaFruta(Fruta fruta) {
        // Verificar si el nombre de la fruta ya existe en la lista
        boolean nombreRepetido = frutas.stream()
                .anyMatch(f -> f.getNombre().equalsIgnoreCase(fruta.getNombre()));
        // Agregar la fruta si el nombre no está repetido, de lo contrario, imprimir un mensaje de error
        if (!nombreRepetido) {
            frutas.add(fruta);
            System.out.println("Fruta agregada con éxito.");
            return true;
        } else {
            System.out.println("Ya existe una fruta con el mismo nombre en la frutería.");
        }
        return false;
    }

    public boolean darBajaFrutaPorNombre(String nombreFruta) {
        return frutas.removeIf(fruta -> fruta.getNombre().equalsIgnoreCase(nombreFruta));
    }

    public boolean darBajaFrutasPorProcedencia(String procedencia) {
        return frutas.removeIf(fruta -> fruta.getProcedencia().equalsIgnoreCase(procedencia));
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

    public boolean subir(double cantidad, int indexFruta) {
        if (indexFruta >= 0 && indexFruta < frutas.size()) {
            Fruta fruta = frutas.get(indexFruta);
            double nuevoPrecioVenta = fruta.getPrecioVentaPorKilo() + cantidad;
            if (nuevoPrecioVenta >= fruta.getPrecioCostePorKilo() && nuevoPrecioVenta < 1000000) {
                fruta.setPrecioVentaPorKilo(nuevoPrecioVenta);
                System.out.println(fruta);
                return true;
            } else {
                System.out.println("La cantidad de precio es demasiado grande y haría que el precio de venta sea innacesible para nuestros clientes");
            }
        }
        return false;
    }

    public double calcularInventarioTotal() {
       /* double valorTotal = 0;
        for (Fruta fruta : frutas) {
            valorTotal += fruta.getPrecioVentaPorKilo() * fruta.getNumeroKilos();
        }
        return valorTotal;*/
        return frutas.stream().mapToDouble(fruta -> fruta.getPrecioVentaPorKilo() * fruta.getNumeroKilos()).sum();
    }

    /*public boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta) {
        return frutas.stream().filter(fruta -> fruta.getNombre().equalsIgnoreCase(nombreFruta))
                .peek(fruta -> fruta.setPrecioVentaPorKilo(nuevoPrecioVenta))
                .findFirst()
                .isPresent();
    }*/
    public boolean actualizarPrecioVenta(String nombreFruta, double nuevoPrecioVenta) {
        return frutas.stream()
                .filter(fruta -> fruta.getNombre().equalsIgnoreCase(nombreFruta))
                .peek(fruta -> fruta.setPrecioVentaPorKilo(nuevoPrecioVenta >= fruta.getPrecioCostePorKilo() ? nuevoPrecioVenta : fruta.getPrecioVentaPorKilo()))
                .findFirst().isPresent();
    }

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

    public boolean reunirFrutasporProcedencia() {
        Scanner entrada = new Scanner(System.in);
        String procedencia = null;
        System.out.println("Ingrese la procedencia");
        do {
            procedencia = entrada.nextLine();
            try {
                EnumComprobacionDirecta.provinciaOK(procedencia);
            } catch (AgregarProvinciasException e) {
                System.out.println("La procedencia ingresada no es válida. Por favor, ingrese una provincia existente.");
                procedencia = ""; // Reiniciar la procedencia para volver a solicitarla
            }
        } while (procedencia.isEmpty());

        List<Fruta> frutasProcedencia = new ArrayList<>();
        for (Fruta fruta : frutas) {
            if (fruta.getProcedencia().strip().equalsIgnoreCase(procedencia)) {
                frutasProcedencia.add(fruta);
            }
        }
        if (!frutasProcedencia.isEmpty()){
            System.out.println("Frutas de " + procedencia + ": ");
            frutasProcedencia.forEach(System.out::println);
            return true;
        }
        return false;
    }

    public boolean buscarFrutaPorNombre(String nombreFruta) {
        boolean valido = false;
        Fruta aux = null;
        for (Fruta fruta : frutas) {
            if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta)) {
                aux = fruta;
                valido = true;
                break;
            }
        }
        if (aux == null) {
            System.out.println("La fruta no se encontró en el inventario.");
        }
        return valido;
    }
    public boolean removeFrutasSinContenido() {
        return frutas.removeIf(fruta -> fruta.getNumeroKilos() <= 0);
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
