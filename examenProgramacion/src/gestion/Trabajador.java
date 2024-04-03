package gestion;

public abstract class Trabajador implements Comparable<Trabajador>{

    protected String nombre, apellidos, departamento;
    protected int añoIncorporacion;
    protected double sueldoDiario,sueldoReal;

    public Trabajador(String nombre, String apellidos, String departamento, int añoIncorporacion, double sueldoDiario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.añoIncorporacion = añoIncorporacion;
        this.sueldoDiario = sueldoDiario;
        this.sueldoReal = 0;
    }

    public Trabajador() {
        String [] nombres = {"pepe","john","manuel","gus","pan","juan","jose","carlos","cruz","a","b","c"};
        this.nombre = nombres[(int) (Math.random()*nombres.length)];
        this.apellidos = nombres[(int) (Math.random()*5)];
        String [] departamentos = {"ventas","marketing","tech","rrhh","direccion"};
        this.departamento= departamentos[(int) (Math.random()*5)];
        this.añoIncorporacion = (int) ((Math.random()*44) + 1980);

    }

    public abstract double calcularSueldo(int dia);

    public abstract int xxAñoIncorporacion();
}
