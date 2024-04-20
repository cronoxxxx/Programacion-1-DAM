package org.example.previas.E1.drafts;

import org.example.previas.E1.common.ProvinciaSpainException;
import org.example.previas.E1.dao.Mostrador;
import org.example.previas.E1.domain.Fruta;
import org.example.previas.E1.dao.Fruteria;
import org.example.previas.E1.common.precioVentaExcepcion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FrutasFicheros {
    public static void main(String[] args) {
        Fruteria a = new Fruteria();
        Mostrador mostrador = new Mostrador();
        //System.out.println(a.mostrarInformacion(true));
        System.out.println(mostrador.mostrarInformacion(true));
        System.out.println(a.mostrarInformacion(true));
        mostrador.venderClienteOnline();
        try(BufferedReader entradaReader = new BufferedReader(new InputStreamReader(System.in));){
            System.out.println("Ingrese el nombre");
            String nombre=entradaReader.readLine();
            System.out.println("Ingrese el numero de kilos a vender");
            int nKilos = Integer.parseInt(entradaReader.readLine());
            if(mostrador.venderClienteFisico(nKilos,nombre)){
                System.out.println("Vendido con exito");
            } else {
                System.err.println("No se pudo realizar la accion");
            }
            Scanner entrada= new Scanner(System.in);
            System.out.println("Ingrese el nombre");
            nombre = entrada.nextLine();
            System.out.println("Ingrese la procedencia");
            String procedencia = entrada.nextLine();
            System.out.println("Ingrese el numero de kilos");
            nKilos = entrada.nextInt();
            System.out.println("Ingrese el precio de coste por kilo");
            double precioCoste = entrada.nextDouble();
            System.out.println("Ingrese el precio de venta por kilo");
            double precioVenta = entrada.nextDouble();
            try {
                a.darAltaFruta(new Fruta(nombre, procedencia, nKilos, precioCoste, precioVenta));
            } catch (precioVentaExcepcion | ProvinciaSpainException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }







        a.escribirFichero();



    }
}
