package EJERCICIOS.CLASESYOBJETOS.Inicial.E6;

public class Coche {
    private String marca,color,matricula;
    private Persona dniTitular;
    private double precio,factor_contaminante,impuestoMatriculacion;
    private int km=0;
    private int year;

    private double impuestoContaminacion;
    public Coche(String matricula, Persona dniTitular, double precio, double impuestoMatriculacion, int km) {
        this.marca = "Ferrari";
        this.color = "Blanco";
        this.matricula = matricula;
        this.dniTitular = dniTitular;
        this.precio = precio;
        this.factor_contaminante = 120.5;
        this.impuestoMatriculacion = impuestoMatriculacion;
        this.km = km;
        this.year = 2024;
    }
    public Coche(String matricula, double factor_contaminante, Persona dniTitular, double precio, double impuestoMatriculacion, int km) {
        this.marca = "Ferrari";
        this.color = "Blanco";
        this.matricula = matricula;
        this.dniTitular = dniTitular;
        this.precio = precio;
        this.factor_contaminante = factor_contaminante;
        this.impuestoMatriculacion = impuestoMatriculacion;
        this.km = km;
        this.year = 2024;
    }

    public void anadirKM(int agregacion){
        if (agregacion<0){
            System.err.println("No se puede colocar un valor menor");
        } else {
            km+=agregacion;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Persona getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(Persona dniTitular) {
        this.dniTitular = dniTitular;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getFactor_contaminante() {
        return factor_contaminante;
    }

    public void setFactor_contaminante(double factor_contaminante) {
        this.factor_contaminante = factor_contaminante;
    }

    public double getImpuestoMatriculacion() {
        return impuestoMatriculacion;
    }

    public void setImpuestoMatriculacion(double impuestoMatriculacion) {
        this.impuestoMatriculacion = impuestoMatriculacion;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double calcularImpuestoContaminacion(){
        if (factor_contaminante<5){
            impuestoContaminacion=precio*0.02;
        } else if (factor_contaminante>5 && factor_contaminante<10){
            impuestoContaminacion=precio*0.05;
        } else {
            impuestoContaminacion=precio*0.1;
        }
        return impuestoContaminacion;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dniTitular='" + dniTitular + '\'' +
                ", precio=" + precio +
                ", factor_contaminante=" + factor_contaminante +
                ", impuestoMatriculacion=" + impuestoMatriculacion +
                ", km=" + km +
                ", year=" + year +
                '}';
    }
}
