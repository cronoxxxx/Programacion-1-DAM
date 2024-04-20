package org.example.previas.E1.drafts;


import net.datafaker.Faker;
import org.example.previas.E1.common.precioVentaExcepcion;
import org.example.previas.E1.dao.DaoFicherosFruta;
import org.example.previas.E1.dao.Fruteria;
import org.example.previas.E1.dao.Mostrador;
import org.example.previas.E1.domain.Fruta;

import java.io.*;

public class Main {
    public static void main(String[] args) {


        try {
            DaoFicherosFruta.crearFicheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Fruteria a = new Fruteria();
        Mostrador mostrador = new Mostrador();
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
            try {
                a.darAltaFruta(new Fruta(nombre,procedencia,nKilos,precioCoste,precioVenta));

            } catch (precioVentaExcepcion e) {
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

            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese el nombre");
                nombre=entradaReader.readLine();
                System.out.println("Ingrese el numero de kilos a vender");
                nKilos = Integer.parseInt(entradaReader.readLine());
                if(mostrador.vender(nKilos,nombre)){
                    System.out.println("Vendido con exito");
                } else {
                    System.err.println("No se pudo realizar la accion");
                }
            }
            System.out.println("Beneficio total: "+a.getBeneficios());

        }catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}