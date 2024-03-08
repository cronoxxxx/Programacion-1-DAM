package EJERCICIOS.CLASESYOBJETOS.Basicos.E5;
/*Crear clase Asignatura, con lo atributos privados int créditos, String nombre. Crear constructores al gusto.*/
public class Asignatura {
    private double creditos;
    private String nombre;

    public Asignatura(double creditos, String nombre) {
        this.creditos = creditos;
        this.nombre = nombre;
    }

    public Asignatura(String nombre) {
        this.creditos = 0;
        this.nombre = nombre;
    }





    @Override
    public String toString() {
        return "Asignatura: "+nombre+"\nCreditos: "+creditos;
    }
}
