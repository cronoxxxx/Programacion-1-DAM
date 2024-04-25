package org.example.drafts;


import org.example.common.FechaInvalidaException;
import org.example.common.precioVentaExcepcion;
import org.example.dao.DaoFicherosFruta;
import org.example.dao.Fruteria;
import org.example.dao.Mostrador;
import org.example.domain.Fruta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        /*List<Fruta> aux = new ArrayList<>();
        Factura factura = new Factura(new ClienteFisico(),aux,12);
        System.out.println(factura);*/
        try {
            DaoFicherosFruta.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Fruteria a = new Fruteria();
        Mostrador mostrador = new Mostrador();
        System.out.println(mostrador.mostrarInformacion(true));
        System.out.println(a.mostrarInformacion(true));

        System.out.println(mostrador.mostrarInformacion(true));

        System.out.println(mostrador.mostrarInformacion(true));
        System.out.println(a.mostrarInformacion(true));
        System.out.println("Ingrese el nombre");
        try (BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));) {
            String nombre = entradaReader.readLine();
            System.out.println("Ingrese la procedencia");
            String procedencia = entradaReader.readLine();
            System.out.println("Ingrese el numero de kilos");
            int nKilos = Integer.parseInt(entradaReader.readLine());
            System.out.println("Ingrese el precio de coste por kilo");
            double precioCoste = Double.parseDouble(entradaReader.readLine());
            System.out.println("Ingrese el precio de venta por kilo");
            double precioVenta = Double.parseDouble(entradaReader.readLine());
            System.out.println("Ingrese una fecha en formato dd-mm-yy:");
            String fechaStr = entradaReader.readLine();

            // Definir el formato de fecha esperado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
            LocalDate fecha = null;
            try {
                // Parsear la fecha ingresada en un objeto LocalDate
                fecha = LocalDate.parse(fechaStr, formatter);
                System.out.println("Fecha ingresada: " + fecha);
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato dd-mm-yy.");
            }
            try {
                a.darAltaFruta(new Fruta(nombre,procedencia,nKilos,precioCoste,precioVenta,fecha,200));

            } catch (precioVentaExcepcion | FechaInvalidaException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Ingrese el nombre de una fruta");
            nombre=entradaReader.readLine();
            System.out.println("El de otra");
            String nombre2 = entradaReader.readLine();
            if (a.frutasDeMismaProcedencia(nombre,nombre2)){
                System.out.println("Exitoso");
            } else {
                System.out.println("Fallo de mi programa");
            }



            System.out.println("Indique el indice al que desea rebajar su precio");
            int index = Integer.parseInt(entradaReader.readLine());
            System.out.println("Ingrese la cantidad a eliminar");
            double cantidad = Double.parseDouble(entradaReader.readLine());
            if(a.rebajar(cantidad,index)){
                System.out.println("Rebaja realizada con exito");
            } else {
                System.err.println("Error en mi programa");
            }



        }catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}