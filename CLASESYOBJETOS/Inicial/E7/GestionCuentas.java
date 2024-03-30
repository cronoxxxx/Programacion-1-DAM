package EJERCICIOS.CLASESYOBJETOS.Inicial.E7;

import java.util.Scanner;

public class GestionCuentas {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese el nombre del titular");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el monto de la cuenta");
        double saldoCuenta = entrada.nextDouble();
        try {
            CuentaBancaria nueva = new CuentaBancaria(saldoCuenta,nombre);
            int opcion;
            double cantidad;
            do {
                System.out.println("Ingrese una opcion");
                opcion = entrada.nextInt();
                switch (opcion){

                    case 1->{
                        System.out.println("Ingrese la cantidad a continuacion");
                        cantidad=entrada.nextDouble();
                        if(nueva.ingreso(cantidad)){
                            System.out.println("Saldo actual: "+nueva.getSaldo());
                        } else {
                            System.out.println("No se ha podido lograr la operacion");
                        }

                    }
                    case 2->{
                        System.out.println("Ingrese la cantidad a continuacion");
                        cantidad=entrada.nextDouble();
                        if(nueva.extraccion(cantidad)){
                            System.out.println("Saldo actual: "+nueva.getSaldo());
                        } else {
                            System.out.println("No se ha podido lograr la operacion");
                        }
                    }
                    case 3-> System.out.println("VUELVA PRONTO !!!");
                    default -> System.err.println("Opcion no valida");
                }
            } while (opcion!=3);

        } catch (SaldoVacioException e) {
            entrada.nextLine();
            System.out.println(e.getMessage());
        }
    }


}
