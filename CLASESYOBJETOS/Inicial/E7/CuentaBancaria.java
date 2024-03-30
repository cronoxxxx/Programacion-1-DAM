package EJERCICIOS.CLASESYOBJETOS.Inicial.E7;

import java.util.Scanner;

/**
* 7.a.8. Ejercicio Cuenta Bancaria. Escribir una clase CuentaBancaria que represente una cuenta bancaria
con estos atributos: numerocuenta, saldo, nombretitular. Hacer métodos que hagan estas funciones:
• void ingreso (int cantidad) - hacer un ingreso en la cuenta
• Void extraccion (int cantidad) - hacer una extracción de la cuenta
La clase ha de tener un constructor con todos los atributos.
Hacer otra clase GestionCuentas que en un método main haga;
• crear una cuenta con saldo inicial 500
• consultar el saldo
• hacer un ingreso de 300
• consultar el saldo
• hacer una extracción de 600
• consultar el saldo
MEJORA 1: Considerar que una cuenta no puede quedar al descubierto (con saldo < 0)
MEJORA 2: Por cada ingreso que se haga en la cuenta se mira si el saldo supera los 1000 euros, en
cuyo caso, se incrementa el saldo en un 2%.
MEJORA 3: Tener en consideración que el crear la cuenta se considera asimismo un ingreso
MEJORA 4: Crear un método que sea ingresoTotal, que recibe un objeto de la clase CuentaBancaria
y pasa todo su dinero a nuestra cuenta.
*
* MEJORA 5: Cambiar el nombre de titular por un objeto de una nueva clase, Persona, que tiene
nombre y apellidos y edad. Cambiar todo y probar. Añadir que, si el titular es menor de edad, no se
pueden hacer extracciones.
*
* **/
public class CuentaBancaria {
    private int nCuenta,autonumerico;
    private double saldo;
    private String nombreTitular;


    public CuentaBancaria(int nCuenta, double saldo, String nombreTitular) throws SaldoVacioException {
        Comprobacion.saldoOK(saldo);
        this.nCuenta = nCuenta;
        this.saldo = saldo;
        this.nombreTitular = nombreTitular;
    }

    public CuentaBancaria(double saldo, String nombreTitular) throws SaldoVacioException {
        Comprobacion.saldoOK(saldo);
        autonumerico++;
        this.nCuenta = autonumerico;
        this.saldo = saldo;
        this.nombreTitular = nombreTitular;
    }

    public boolean ingreso (double cantidad) {
        Scanner entrada= new Scanner(System.in);
        try {
            Comprobacion.saldoOK(cantidad);
            this.saldo+=cantidad;
            return true;
        } catch (SaldoVacioException e) {
            entrada.nextLine();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean extraccion (double cantidad) {
        Scanner entrada= new Scanner(System.in);
        try {
            Comprobacion.saldoOK(cantidad);
            if (saldo-cantidad>0){
                this.saldo-=cantidad;
                return true;
            } else {
                System.err.println("NO ES VALIDO");
            }
        } catch (SaldoVacioException e) {
            entrada.nextLine();
            System.out.println(e.getMessage());
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }
}
