package org.example.previas.E1.drafts;

import org.example.previas.E1.common.AgregarProvinciasException;
import org.example.previas.E1.common.EnumComprobacionDirecta;
import org.example.previas.E1.common.FechaInvalidaException;
import org.example.previas.E1.common.precioVentaExcepcion;
import org.example.previas.E1.dao.Fruteria;
import org.example.previas.E1.domain.Fruta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Fruteria a = new Fruteria();
        System.out.println(a.mostrarInformacion(true));
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese la procedencia");
        String procedencia = entrada.nextLine();
        try {
            EnumComprobacionDirecta.provinciaOK(procedencia);
        } catch (AgregarProvinciasException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ingrese el numero de kilos");
        int nKilos = entrada.nextInt();
        System.out.println("Ingrese el precio de coste por kilo");
        double precioCoste = entrada.nextDouble();
        System.out.println("Ingrese el precio de venta por kilo");
        double precioVenta = entrada.nextDouble();
        System.out.println("Ingrese una fecha en formato dd-mm-yy:");
        String fechaStr = entrada.nextLine();

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
            a.darAltaFruta(new Fruta(nombre,procedencia,nKilos,precioCoste,precioVenta,fecha));

        } catch (precioVentaExcepcion | FechaInvalidaException e) {
            System.out.println(e.getMessage());
        }
        try {
            a.darAltaFruta(new Fruta(nombre, procedencia, nKilos, precioCoste, precioVenta, fecha));
        } catch (precioVentaExcepcion | FechaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}
