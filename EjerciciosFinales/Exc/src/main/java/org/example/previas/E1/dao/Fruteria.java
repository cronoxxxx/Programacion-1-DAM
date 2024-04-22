package org.example.previas.E1.dao;

import org.example.previas.E1.common.*;
import org.example.previas.E1.domain.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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


    public boolean darAltaFruta(Fruta fruta) {
        // Verificar si el nombre de la fruta ya existe en la lista
        boolean nombreRepetido = frutas.stream().anyMatch(f -> f.getNombre().equalsIgnoreCase(fruta.getNombre()));
        // Agregar la fruta si el nombre no está repetido, de lo contrario, imprimir un mensaje de error
        if (!nombreRepetido) {
            frutas.add(fruta);
            System.out.println(Constantes.FRUTAAGREGADACONEXITO);
            return true;
        } else {
            System.out.println(Constantes.YAEXISTEUNAFRUTACONELMISMONOMBREENLAFRUTERIA);
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
                System.out.println(Constantes.LACANTIDADDEREBAJAESDEMASIADOGRANDEYHARIAQUEELPRECIODEVENTASEAMENORQUEELPRECIODECOSTE);
            }
        }
        return false;
    }

    public boolean rebajarNombreFruta(double cantidad, String nombreFruta) {
        Fruta auxLista = null;
        for (Fruta fruta : frutas) {
            if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta)) {
                auxLista = fruta;
            }
        }
        if (auxLista != null) {
            double nuevoPrecioVenta = auxLista.getPrecioVentaPorKilo() - cantidad;
            if (nuevoPrecioVenta >= auxLista.getPrecioCostePorKilo()) {
                auxLista.setPrecioVentaPorKilo(nuevoPrecioVenta);
                System.out.println(auxLista);
            } else {
                System.out.println(Constantes.LACANTIDADDEREBAJAESDEMASIADOGRANDEYHARIAQUEELPRECIODEVENTASEAMENORQUEELPRECIODECOSTE);
                return false;
            }
        } else {
            System.err.println(Constantes.NOSEHANENCONTRADONINGUNAFRUTALLAMADA + nombreFruta);
            return false;
        }
        return true;
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
                System.out.println(Constantes.LACANTIDADDEPRECIOESDEMASIADOGRANDEYHARIAQUEELPRECIODEVENTASEAINNACESIBLEPARANUESTROSCLIENTES);
            }
        }
        return false;
    }

    public boolean subirNombreFruta(double cantidad, String nombreFruta) {
        Fruta auxLista = null;
        for (Fruta fruta : frutas) {
            if (fruta.getNombre().strip().equalsIgnoreCase(nombreFruta)) {
                auxLista = fruta;
            }
        }
        if (auxLista != null) {
            double nuevoPrecioVenta = auxLista.getPrecioVentaPorKilo() + cantidad;
            if (nuevoPrecioVenta >= auxLista.getPrecioCostePorKilo() && nuevoPrecioVenta < 1000000) {
                auxLista.setPrecioVentaPorKilo(nuevoPrecioVenta);
                System.out.println(auxLista);
            } else {
                System.out.println(Constantes.LACANTIDADDEPRECIOESDEMASIADOGRANDEYHARIAQUEELPRECIODEVENTASEAINNACESIBLEPARANUESTROSCLIENTES);
                return false;
            }
        } else {
            System.err.println(Constantes.NOSEHAENCONTRADOLAFRUTALLAMADA + nombreFruta);
            return false;
        }
        return true;
    }

    public double calcularInventarioTotal() {
        return frutas.stream().mapToDouble(fruta -> fruta.getPrecioVentaPorKilo() * fruta.getNumeroKilos()).sum();
    }

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
                            System.out.println(Constantes.SEHANENCONTRADODOSFRUTASCONLAMISMAPROCEDENCIA + frutas.get(i) + "\n" + frutas.get(j));
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
        System.out.println(Constantes.INGRESELAPROCENDENCIA);
        do {
            procedencia = entrada.nextLine();
            try {
                EnumComprobacionDirecta.provinciaOK(procedencia);
            } catch (AgregarProvinciasException e) {
                System.out.println(Constantes.LAPROCENDENCIAINGRESANOESVALIDAPORFAVORINGRESAUNAPROVINCIAEXISTENTE);
                procedencia = ""; // Reiniciar la procedencia para volver a solicitarla
            }
        } while (procedencia.isEmpty());
        Map<String, List<Fruta>> frutasPorProcedencia = frutas.stream().collect(Collectors.groupingBy(Fruta::getProcedencia));
        List<Fruta> frutasProcedencia = frutasPorProcedencia.get(procedencia);
        if (!frutasProcedencia.isEmpty()) {
            System.out.println(Constantes.FRUTASDE + procedencia);
            System.out.println(Constantes.SEPARADOR);
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
            System.out.println(Constantes.LAFRUTANOSEENCONTROENELINVENTARIO);
        }
        return valido;
    }

    public boolean removeFrutasSinContenido() {
        return frutas.removeIf(fruta -> fruta.getNumeroKilos() <= 0);
    }

    public boolean eliminarFrutasCaducadas() {
        return frutas.removeIf(fruta -> fruta.getFechaCaducidad().equals(LocalDate.now()));
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
