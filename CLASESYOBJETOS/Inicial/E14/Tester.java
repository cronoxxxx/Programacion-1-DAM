package EJERCICIOS.CLASESYOBJETOS.Inicial.E14;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Vestido[] vestidos = new Vestido[3];
        for (int i = 0; i < vestidos.length; i++) {
            if (vestidos[i]==null){
                System.out.println("Ingrese el nombre del vestido");
                String n = entrada.nextLine();
                System.out.println("Ingrese la marca");
                String m = entrada.nextLine();
                System.out.println("Ingrese su talla");
                int t = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Esta en temporada de rebaja? (si/no) ");
                String r;
                boolean isTemp = false;
                do {
                    r = entrada.nextLine();
                    if (r.strip().equalsIgnoreCase("si")) {
                        isTemp = true;
                    } else if (r.strip().equalsIgnoreCase("no")) {
                        isTemp = false;
                    } else {
                        System.err.println("Respuesta no valida");
                    }
                } while (!(r.strip().equalsIgnoreCase("si") || r.strip().equalsIgnoreCase("no")));
                System.out.println("Cuantas unidades en almacen tiene?");
                int c = entrada.nextInt();
                entrada.nextLine();
                Vestido nuevoVestido = new Vestido(n, m, t, isTemp, c);

                // Verificar si el vestido ya está en la lista
                if (containsVestido(vestidos, nuevoVestido)) {
                    System.out.println("No se pueden ingresar vestidos iguales.");
                    i--; // Retroceder para volver a ingresar la información
                } else {
                    vestidos[i] = nuevoVestido;
                }
            }
        }

        System.out.println(Arrays.toString(vestidos).replace("[","").replace("]",""));
        double mediaPrecio=0;
        int contador = 0;
        System.out.println("Vestido más caro: ");
        Vestido vestidoMasCaro = vestidos[0];
        mediaPrecio+= vestidoMasCaro.getPrecio();
        for (int i = 1; i < vestidos.length; i++) {
            mediaPrecio+=vestidos[i].getPrecio();
            if (vestidos[i].compareTo(vestidoMasCaro) > 0) {
                vestidoMasCaro = vestidos[i];
            }
        }
        System.out.println("Nombre del vestido mas caro: "+ vestidoMasCaro.getNombre());
        System.out.println("Media del precio de los vestidos: "+mediaPrecio/vestidos.length);


        System.out.println("Precio de los vestidos sin rebaja o que no estan en temporada de descuento");
        for (int i = 0; i < vestidos.length; i++) {
            if (vestidos[i]!=null){
                if (vestidos[i].precioEnRebajas()!=-1){
                    System.out.println(vestidos[i].precioEnRebajas());
                }
            }
        }

        System.out.println("Ingrese el nombre del vestido");
        String n = entrada.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < vestidos.length && !encontrado; i++) {
            if (vestidos[i]!=null){
                if (vestidos[i].getNombre().strip().equalsIgnoreCase(n)){
                    System.out.println("Ingrese las unidades que desea quitar");
                    int c = entrada.nextInt();
                    if (vestidos[i].retirarUnidades(c)){
                        System.out.println("Retirado exitosamente");
                        System.out.println(vestidos[i]);
                        System.out.println("Importe en almacen normal: "+vestidos[i].importeEnAlmacen());
                        System.out.println("Importe en almacen con descuento: "+vestidos[i].importeEnAlmacen(true));
                        encontrado=true;
                    } else {
                        System.err.println("No se ha podido completar la accion");
                    }
                }
            }
        }
        entrada.nextLine();
        System.out.println("Ingrese el nombre del vestido");
        n = entrada.nextLine();
        encontrado = false;
        for (int i = 0; i < vestidos.length && !encontrado; i++) {
            if (vestidos[i]!=null){
                if (vestidos[i].getNombre().strip().equalsIgnoreCase(n)){
                    System.out.println("Ingrese el porcentaje a aumentar");
                    int c = entrada.nextInt();
                    vestidos[i].aumentarPrecio(c);
                    System.out.println(vestidos[i]);
                    encontrado=true;
                }
            }
        }








    }
    private static boolean containsVestido(Vestido[] vestidos, Vestido nuevoVestido) {
        for (Vestido v : vestidos) {
            if (v != null && v.equals(nuevoVestido)) {
                return true;
            }
        }
        return false;
    }
}
