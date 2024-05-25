package org.example.drafts;

import org.example.dao.Mostrador;
import org.example.domain.Cliente;

import java.util.List;
import java.util.Scanner;

public class ReFormatMostrador {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);

        Mostrador mostrador = new Mostrador();

        System.out.println(mostrador.getFruteria().getFrutas());
        System.out.println(mostrador.mostrarInformacion(true));
        StringBuilder sb = new StringBuilder();
        sb.append("Manzana49").append(", ").append("Pera44").append(", ");
        Cliente prueba = mostrador.devolverClienteFisico();
        if (prueba!=null){
            if (mostrador.venderClienteFisico(prueba, sb, 2)) {
                System.out.println("Venta realizada con éxito");
                System.out.println(mostrador.getFacturas());
            } else {
                System.out.println("No se pudo realizar la venta");
            }
        } else {
            System.out.println("Cliente vacio");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Manzana49").append(", ").append("Pera44").append(", ");
        Cliente prueba2 = mostrador.devolverClienteOnline(2);
        if (prueba2!=null){
            if (mostrador.venderClienteOnline(prueba2,sb2,2)){
                System.out.println("Venta realizada con exito");
                System.out.println(mostrador.getFacturas());
            } else {
                System.err.println("No se pudo realizar la venta");
            }
        } else {
            System.err.println("Cliente vacio");
        }
        System.out.println("Ingrese");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese");
        String apellido = entrada.nextLine();
        List<Cliente> eliminar = mostrador.clienteAccion(nombre,apellido);
        Cliente aux = null;
        if (!eliminar.isEmpty()){
            for (int i = 0; i < eliminar.size() ; i++) {
                System.out.println(i+". "+eliminar.get(i).getNombre());
            }
        } else {
            System.err.println("no");
        }

        System.out.println("Seleccione el que desea eliminar");
        int x = entrada.nextInt();
        aux = eliminar.get(x);
        if (mostrador.removeClienteporNombreApellidos(aux)){
            System.out.println("Cliente eliminado con exito");
        } else {
            System.err.println("no");
        }
        System.out.println(mostrador.mostrarInformacion(true));
        entrada.nextLine();
        System.out.println("Ingrese");
        nombre = entrada.nextLine();
        System.out.println("Ingrese");
        apellido = entrada.nextLine();
        List<Cliente> descontar = mostrador.clienteAccion(nombre,apellido);
        for (int i = 0; i < descontar.size() ; i++) {
            System.out.println(i+". "+descontar.get(i).getNombre());
        }
        System.out.println("Seleccione el que desea eliminar");
        x = entrada.nextInt();
        Cliente aux2 = null;
        aux2 = descontar.get(x);
        if (mostrador.aplicarDescuentosporClienteNombreApellidos(aux2)){
            System.out.println("Aplicado descuento con exito");
        } else {
            System.err.println("No se aplico");
        }

        System.out.println(mostrador.mostrarInformacion(true));


    }
}
