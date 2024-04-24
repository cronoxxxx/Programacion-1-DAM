package org.example.drafts;

import org.example.common.AgregarProvinciasException;
import org.example.common.EnumComprobacionDirecta;
import org.example.common.FechaInvalidaException;
import org.example.common.precioVentaExcepcion;
import org.example.dao.Fruteria;
import org.example.dao.Mostrador;
import org.example.domain.Fruta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FrutasFicheros {
    public static void main(String[] args) {
        Fruteria a = new Fruteria();
        Mostrador mostrador = new Mostrador();
        //System.out.println(a.mostrarInformacion(true));
        System.out.println(mostrador.mostrarInformacion(true));
        System.out.println(a.mostrarInformacion(true));

        try(BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("Ingrese el nombre");
            String nombre=entradaReader.readLine();
            System.out.println("Ingrese el numero de kilos a vender");
            int nKilos = Integer.parseInt(entradaReader.readLine());

            Scanner entrada= new Scanner(System.in);
            System.out.println("Ingrese el nombre");
            nombre = entrada.nextLine();
            System.out.println("Ingrese la procedencia");
            String procedencia = entrada.nextLine();
            try {
                EnumComprobacionDirecta.provinciaOK(procedencia);
            } catch (AgregarProvinciasException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ingrese el numero de kilos");
            nKilos = entrada.nextInt();
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
                a.darAltaFruta(new Fruta(nombre, procedencia, nKilos, precioCoste, precioVenta,fecha));
            } catch (precioVentaExcepcion | FechaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }







        a.escribirFichero();



    }
}
