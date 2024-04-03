package gestion;

public class Jefe extends Trabajador implements Comparable<Trabajador>{

    private int cantidadTrabajadores;

    public Jefe() {
        this.sueldoDiario = ((Math.random() * 60000)+40000) / 365;
        this.sueldoReal = calcularSueldo((int)(Math.random()*31)+1);
        this.cantidadTrabajadores = (int)(Math.random()*1000);
    }

    public Jefe(String nombre, String apellidos, String departamento, int añoIncorporacion, double sueldoDiario, int cantidadTrabajadores, int dia) {
        super(nombre, apellidos, departamento, añoIncorporacion, sueldoDiario);
        this.cantidadTrabajadores = cantidadTrabajadores;
        this.sueldoReal = calcularSueldo(dia);
    }

    @Override
    public double calcularSueldo(int dia) {
        double sueldo = dia *sueldoDiario;
        if (sueldo >0 ){
            double incremento = 0.02* cantidadTrabajadores;

            sueldo+=incremento;
            this.sueldoReal=sueldo;
            return this.sueldoReal;
        } else {
            return -1;
        }
    }

    public int getCantidadTrabajadores() {
        return cantidadTrabajadores;
    }

    public void setCantidadTrabajadores(int cantidadTrabajadores) {
        this.cantidadTrabajadores = cantidadTrabajadores;
    }

    @Override
    public String toString() {

        return String.format("Cantidad de trabajadores: %d\nNombre: %s\nApellidos: %s,\nDepartamento: %s\n Año de incorporacion: %d\nSueldo diario: %.2f\nSueldo Real: %.2f",cantidadTrabajadores,nombre,apellidos,departamento,añoIncorporacion,sueldoDiario,sueldoReal);


    }


    public int xxAñoIncorporacion() {
        return this.añoIncorporacion;
    }

    @Override
    public int compareTo(Trabajador o) {
        return Integer.compare(this.añoIncorporacion,o.añoIncorporacion);
    }
}
