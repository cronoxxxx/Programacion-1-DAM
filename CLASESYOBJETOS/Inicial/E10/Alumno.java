package EJERCICIOS.CLASESYOBJETOS.Inicial.E10;


import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 11.Crear una clase llamada Alumno con los atributos privados:
 * • String nombre
 * • double[] notas (array que tendrá 3 elementos, y que va a guardar las notas de cada una de
 * las tres evaluaciones del alumno)
 * Implementa el siguiente constructor:
 * • Alumno (String nombre) (el constructor no recibe el array de notas, sino que lo crea. Al
 * crearse un array Java lo rellena automáticamente con 0, así que de este modo se va a
 * considerar que una evaluación no tiene nota aún si en el array, en su posición, hay un cero)
 * Implementa los siguientes métodos públicos:
 * • Getter y setter para el atributo nombre.
 * • boolean ponerNota(int evaluacion, double nota). Guardará la nota correspondiente a la
 * evaluación indicada. Las notas van del 1 al 10 y las evaluaciones del 1 al 3. Devuelve false si
 * los parámetros no son válidos.
 * • boolean borrarNota(int evaluacion). Borra la nota de la evaluación indicada. Da false si
 * los parámetros no son válidos.
 * • int numeroNotas( ). Devuelve el número de notas del alumno.
 * • double notaMaxima( ). Devuelve la nota máxima del alumno. -1 si no tiene notas.
 * • boolean tieneNota(int evaluacion). Da true si el alumno tiene nota para la evaluación
 * indicada. False si no, o número de evaluación no válida.
 * • double getNota(int evaluacion). Devuelve la nota de la evaluación pasada como
 * parámetro. -1 si la evaluación no es válida o no hay nota
 * Crea una clase Prueba con un main y con un array con varios alumnos para probar todas las
 * funcionalidades de la clase Alumno a través de sus métodos.
 */
public class Alumno {
    private String nombre;
    private double [] notas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new double[3];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public boolean ponerNota (int evaluacion, double nota ){
        if (evaluacion<=3 && evaluacion>0 && nota>0 && nota<10){
            notas[evaluacion-1]=nota;
            return true;
        }
        return false;
    }
    public boolean borrarNota (int evaluacion ){
        if (evaluacion<3 && evaluacion>0){
            notas[evaluacion-1]=0;
            return true;
        }
        return false;
    }
    public int numeroNotas (){
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i]!=0){
                contador++;

            }
        }
        return contador;
    }

    public double notaMaxima (){
        double notaMax = notas[0];
        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notaMax<notas[i]){
                notaMax = notas[i];
            } else if (notas[i]==0){
                contador++;
            }
        }
        if (contador==notas.length){
            return -1;
        } else {
            return notaMax;
        }
    }

    public double getNotaEvaluacion (int evaluacion){

        for (int i = 0; i < notas.length ; i++) {
            if (i==evaluacion-1 && notas[i]!=0){
                return notas[i];

            }
        }
        return -1;
    }
    public boolean tieneNota (int evaluacion){
        return evaluacion<=notas.length && notas[evaluacion-1]!=0;
    }

    @Override
    public String toString() {
        return String.format ("Nombre: %s\nNotas: %s",nombre, Arrays.toString(notas).replace("[", "").replace("]", ""));
    }
}
