package gestion;

import java.util.Arrays;

public class Programador extends Trabajador implements Comparable<Trabajador>{
    private String [] lenguajes;

    public Programador(String nombre, String apellidos, String departamento, int añoIncorporacion, double sueldoDiario, String[] imports, int dia) {
        super(nombre, apellidos, departamento, añoIncorporacion, sueldoDiario);
        lenguajes = new String[50];

        for (int i = 0, j = 0; i < lenguajes.length; i++) {
            lenguajes[i]=imports[j];
            j++;



        }
        this.sueldoReal = calcularSueldo(dia);
    }

    public Programador() {
        this.sueldoDiario = ((Math.random() * 40000)+18000) / 365;
        lenguajes = new String[50];
        String [] recorrer = {"Kotin","C#","Java","Python","C++"};
        for (int i = 0, j ; i < lenguajes.length; i++) {
            if (i < 3) {
                j = (int) (Math.random()*recorrer.length);
                lenguajes[i]= recorrer[j];
            }
        }
        this.sueldoReal = calcularSueldo((int)(Math.random()*31)+1);
    }

    @Override
    public double calcularSueldo(int dia) {
        double sueldo = dia *sueldoDiario;
        if (sueldo >0 ){
            double incremento = 0.05* lenguajes.length;

            sueldo+=incremento;
            this.sueldoReal=sueldo;
            return this.sueldoReal;
        } else {
            return -1;
        }
    }


    public int xxAñoIncorporacion() {
        return this.añoIncorporacion;
    }

    public String[] getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguaje) {
        boolean vacio = false;
        for (int i = 0; i < this.lenguajes.length && !vacio; i++) {
            if (lenguajes[i]==null){
                vacio=true;
                lenguajes[i]=lenguaje;
            }
        }
    }



    @Override
    public String toString() {
        System.out.println("Lenguajes");
        for (int i = 0; i < lenguajes.length; i++) {

            if (lenguajes[i]!=null){
                System.out.print(lenguajes[i]+ " ");
            }
        }

        return String.format("\nNombre: %s\nApellidos: %s,\nDepartamento: %s\nAño de incorporacion: %d\nSueldo diario: %.2f\nSueldo Real: %.2f",nombre,apellidos,departamento,añoIncorporacion,sueldoDiario,sueldoReal);
    }



    @Override
    public int compareTo(Trabajador o) {
        return Integer.compare(this.añoIncorporacion,o.añoIncorporacion);
    }
}
