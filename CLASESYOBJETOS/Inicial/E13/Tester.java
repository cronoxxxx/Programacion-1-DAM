package EJERCICIOS.CLASESYOBJETOS.Inicial.E13;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {Scanner entrada= new Scanner(System.in);
        EmpresaAlquiler emp = null;
        Coche [] coche = new Coche[2];
        for (int i = 0; i < coche.length; i++) {

            System.out.println("Ingresa el modelo del vehiculo: ");
            String modelo = entrada.nextLine();
            System.out.println("Marca: ");
            String marca = entrada.nextLine();
            System.out.println("Año de matriculacion: ");
            String year = entrada.nextLine();
            String estado;
            do {
                System.out.println("Estado: (alquilado/no alquilado)");
                estado = entrada.nextLine();
            } while (!(estado.strip().equalsIgnoreCase("alquilado") || estado.strip().equalsIgnoreCase("no alquilado")));

            int cat;
            do {System.out.println("Categoria 1 o 2?");
                cat = entrada.nextInt();
            } while (!(cat == 1 || cat==2));
            entrada.nextLine();
            try {
                coche [i]= new Coche(modelo,marca,year,estado,cat);
            } catch (EstadoCocheException | CategoriaCocheException e) {
                entrada.nextLine();
                System.out.println(e.getMessage());
            } 
        }
        try {
            emp = new EmpresaAlquiler(coche);
            emp.mostrarDatosVehiculos();
            System.out.println("Ingrese el matricula del coche que desee alquilar");
            String mat = entrada.nextLine();
            System.out.println("Ingrese los dias que lo va a querer");
            int dias = entrada.nextInt();
            emp.precioAlquilerCoche(dias, mat);
            emp.mostrarDatosVehiculos();
            entrada.nextLine();
            System.out.println("Ingresa la matricula para saber si es un coche alquilado o no");
            mat = entrada.nextLine();
            if(emp.isAlquilado(mat)==null){
                System.out.println("Vehiculo no existente o posiblemente ya alquilado");
            } else {
                System.out.println(emp.isAlquilado(mat));
            }
            System.out.println("Cantidad de alquilados y su ganancia");
            emp.cantidadAlquilados();
            emp.gananciaAlquilados();
        } catch (EstadoCocheException | CategoriaCocheException e) {
            entrada.nextLine();
            System.out.println(e.getMessage());
        }

    }
}
